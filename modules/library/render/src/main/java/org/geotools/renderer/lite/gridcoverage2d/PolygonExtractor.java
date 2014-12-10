/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 * 
 *    (C) 2014, Open Source Geospatial Foundation (OSGeo)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package org.geotools.renderer.lite.gridcoverage2d;

import java.util.ArrayList;
import java.util.List;

import org.opengis.referencing.FactoryException;
import org.opengis.referencing.operation.TransformException;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryComponentFilter;
import com.vividsolutions.jts.geom.Polygon;

/**
 * A simple utility class extracting all polygons found in the geometry provided
 * 
 * @author Andrea Aime - GeoSolutions
 * 
 */
class PolygonExtractor {

    /**
     * Returns all polygons found in the
     * 
     * @param handler
     * @param geometry
     * @return
     * @throws TransformException
     * @throws FactoryException
     */
    public List<Polygon> getPolygons(Geometry preProcessed) throws TransformException,
            FactoryException {
        // the pre-processing might have cut or split the geometry
        final List<Polygon> polygons = new ArrayList<Polygon>();
        if (preProcessed instanceof Polygon) {
            polygons.add((Polygon) preProcessed);
        } else {
            preProcessed.apply(new GeometryComponentFilter() {

                @Override
                public void filter(Geometry geom) {
                    if (geom instanceof Polygon) {
                        polygons.add((Polygon) geom);
                    }
                }
            });
        }
        return polygons;
    }

}

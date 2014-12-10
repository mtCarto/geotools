package org.geotools.filter.function.math;

/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 * 
 *    (C) 2005-2008, Open Source Geospatial Foundation (OSGeo)
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

//this code is autogenerated - you shouldnt be modifying it!
import static org.geotools.filter.capability.FunctionNameImpl.parameter;

import static org.geotools.filter.capability.FunctionNameImpl.parameter;

import org.geotools.filter.FunctionExpressionImpl;
import org.geotools.filter.capability.FunctionNameImpl;
import org.opengis.filter.capability.FunctionName;

/**
 * 
 *
 * @source $URL$
 */
public class FilterFunction_min_2 extends FunctionExpressionImpl {

    //public static FunctionName NAME = new FunctionNameImpl("min_2","long","long");
    public static FunctionName NAME = new FunctionNameImpl("min_2",
            parameter("minium", Long.class),
            parameter("long",Number.class),
            parameter("long",Number.class));

    public FilterFunction_min_2() {
        super("min_2");
        functionName = NAME;
    }

    public Object evaluate(Object feature) {
        long arg0;
        long arg1;

        try { // attempt to get value and perform conversion
            arg0 = (getExpression(0).evaluate(feature,Long.class)).longValue();
        } catch (Exception e) {
            // probably a type error
            throw new IllegalArgumentException(
                    "Filter Function problem for function min argument #0 - expected type long");
        }

        try { // attempt to get value and perform conversion
            arg1 = (getExpression(1).evaluate(feature,Long.class)).longValue();
        } catch (Exception e) {
            // probably a type error
            throw new IllegalArgumentException(
                    "Filter Function problem for function min argument #1 - expected type long");
        }

        return new Long(Math.min(arg0, arg1));
    }
}

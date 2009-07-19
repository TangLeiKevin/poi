/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */

package org.apache.poi.xssf.usermodel.examples;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.POIXMLProperties;

/**
 *  How to set extended and custom properties
 *
 * @author Yegor Kozlov
 */
public class WorkbookProperties {

    public static void main(String[]args) throws Exception {

        XSSFWorkbook workbook = new XSSFWorkbook();
        workbook.createSheet("Workbook Properties");

        POIXMLProperties props = workbook.getProperties();

        /**
         * Extended properties are a predefined set of metadata properties
         * that are specifically applicable to Office Open XML documents.
         * Extended properties consist of 24 simple properties and 3 complex properties stored in the
         *  part targeted by the relationship of type
         */
        POIXMLProperties.ExtendedProperties ext =  props.getExtendedProperties();
        ext.getUnderlyingProperties().setCompany("Apache Software Foundation");
        ext.getUnderlyingProperties().setTemplate("XSSF");

        /**
         * Custom properties enable users to define custom metadata properties
         * through a set of well-defined data types. For example, a custom
         * OLE Editor property of type string can be defined as follows:
         *
         *  <property fmtid="{D5CDD505-2E9C-101B-9397-08002B2CF9AE}" pid="2" name="Editor">
         *    <vt:lpwstr>John Smith</vt:lpwstr>
         *  </property>
         */
        
        POIXMLProperties.CustomProperties cust =  props.getCustomProperties();
        org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
                property = cust.getUnderlyingProperties().addNewProperty();

        property.setFmtid("{D5CDD505-2E9C-101B-9397-08002B2CF9AE}");
        property.setPid(2);
        property.setName("Editor");
        property.setLpwstr("John Smith");
        
        FileOutputStream out = new FileOutputStream("workbook.xlsx");
        workbook.write(out);
        out.close();

    }


}
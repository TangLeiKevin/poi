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

package org.apache.poi.sl.usermodel;

public interface TableShape<
    S extends Shape<S,P>,
    P extends TextParagraph<S,P,?>
> extends Shape<S,P>, PlaceableShape<S,P> {
    int getNumberOfColumns();
    
    int getNumberOfRows();
    
    TableCell<S,P> getCell(int row, int col);
    
    /**
     * Gets the width (in points) of the n-th column
     *
     * @param idx the column index (0-based)
     * @return the width (in points)
     */
    double getColumnWidth(int idx);
    
    /**
     * Sets the width (in points) of the n-th column
     *
     * @param idx the column index (0-based)
     * @param width the width (in points)
     */
    void setColumnWidth(int idx, double width);

    /**
     * Gets the row height
     *
     * @param row the row index (0-based)
     * @return the height (in points)
     */
    double getRowHeight(int row);
    
    /**
     * Sets the row height.
     *
     * @param row the row index (0-based)
     * @param height the height to set (in points)
     */
    void setRowHeight(int row, double height);
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.

*/

package org.yourorghere;

/**
 *
 * @author mjz4777
 */


 
public class CryusBeckClipper {
    Plane[] planes = null;
    
    // modifies the points p1 and p2 so that the line segment joining
    // p1 and p2 is clipped to lie inside the convex polyhedron
    // returns whether any of line remaining to draw after clipping
    // note that p1 and/or p2 might be given infinite coordinates
    // if planes did not give a closed surface
    public boolean clip(Point3D p1, Point3D p2)
    { 
      
        Vector3D v = p2.subtract(p1); // direction vector for line
        double tIn = Double.NEGATIVE_INFINITY;
        double tOut = Double.POSITIVE_INFINITY;
        
        // iterate through each plane in turn
        if(planes == null)
            return false;
        
        for (Plane plane : planes){
            Vector3D pDifference = plane.getPoint().subtract(p1);
            Vector3D n = plane.getNormal(); // normal vector to plane
            double nDotDifference = n.dotProduct(pDifference);
            double nDotV = n.dotProduct(v);
            // check n.v
            if (nDotV == 0.0) // line is exactly parallel to plane
            {
                if (nDotDifference < 0)
                    return false; // line on outside half space of plane
            }
            else
            {
                double tHit = nDotDifference/nDotV;
                if (nDotV < 0) // tHit is candidate value for tIn
                    tIn = Math.max(tIn, tHit);
                else // nDotV > 0 so tHit is candidate value for tOut
                    tOut = Math.min(tOut, tHit);
                if (tIn > tOut)
                return false;
            }
        }
        // clip the points p1 and p2
        double p1x = p1.getX(), p1y = p1.getY(), p1z = p1.getZ();
        double vx = v.getX(), vy = v.getY(), vz = v.getZ();
        
        if (tIn > 0.0) // clip past p1
            p1.set(p1x+tIn*vx, p1y+tIn*vy, p1z+tIn*vz);
        if (tOut < 1.0) // clip before p2
            p2.set(p1x+tOut*vx, p1y+tOut*vy, p1z+tOut*vz);
        return true;
    }

}
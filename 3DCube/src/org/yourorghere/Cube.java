/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import javax.media.opengl.GL;

/**
 *
 * @author ºúê¿Óî
 */
public class Cube {
    
    public void drawCube(GL gl)
    {
        gl.glPolygonMode( GL.GL_FRONT_AND_BACK, GL.GL_LINE );
        gl.glBegin(GL.GL_POLYGON);
        //gl.glColor3f(0, 0, 0);
        gl.glVertex3f(0, 0, 0);
        //gl.glColor3f(1, 0, 0);
        gl.glVertex3f(5, 0, 0);
        //gl.glColor3f(1, 0, 1);
        gl.glVertex3f(5, 0, 5);
        //gl.glColor3f(0, 0, 1);
        gl.glVertex3f(0, 0, 5);
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);
        //gl.glColor3f(0, 0, 0);
        gl.glVertex3f(0, 0, 0);
        //gl.glColor3f(0, 1, 0);
        gl.glVertex3f(0, 5, 0);
        //gl.glColor3f(0, 1, 1);
        gl.glVertex3f(0, 5, 5);
        //gl.glColor3f(0, 0, 1);
        gl.glVertex3f(0, 0, 5);
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);
        //gl.glColor3f(0, 0, 0);
        gl.glVertex3f(0, 0, 0);
        //gl.glColor3f(0, 1, 0);
        gl.glVertex3f(0, 5, 0);
        //gl.glColor3f(1, 1, 0);
        gl.glVertex3f(5, 5, 0);
        //gl.glColor3f(1, 0, 0);
        gl.glVertex3f(5, 0, 0);
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);
        //gl.glColor3f(0, 0, 1);
        gl.glVertex3f(0, 0, 5);
        //gl.glColor3f(0, 1, 1);
        gl.glVertex3f(0, 5, 5);
        //gl.glColor3f(1, 1, 1);
        gl.glVertex3f(5, 5, 5);
        //gl.glColor3f(1, 0, 1);
        gl.glVertex3f(5, 0, 5);
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);
        //gl.glColor3f(0, 1, 0);
        gl.glVertex3f(0, 5, 0);
        //gl.glColor3f(1, 1, 0);
        gl.glVertex3f(5, 5, 0);
        //gl.glColor3f(1, 1, 1);
        gl.glVertex3f(5, 5, 5);
        //gl.glColor3f(0, 1, 1);
        gl.glVertex3f(0, 5, 5);
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);
        //gl.glColor3f(1, 0, 0);
        gl.glVertex3f(5, 0, 0);
        //gl.glColor3f(1, 1, 0);
        gl.glVertex3f(5, 5, 0);
        //gl.glColor3f(1, 1, 1);
        gl.glVertex3f(5, 5, 5);
        //gl.glColor3f(1, 0, 1);
        gl.glVertex3f(5, 0, 5);
        gl.glEnd();
    }
    
}

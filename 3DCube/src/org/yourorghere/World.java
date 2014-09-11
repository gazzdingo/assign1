package org.yourorghere;

/**
 *
 * @author ºúê¿Óî
 */
import javax.media.opengl.*;
import com.sun.opengl.util.Animator;
import javax.media.opengl.glu.GLU;


public class World  implements GLEventListener{
  private  Animator theAnimator;

// for look at
  private float eyeX = 15;
  private float eyeY = 7;
  private float eyeZ = 15;
  private float atX = 0;
  private float atY = 0;
  private float atZ = 0;
  private float upX = 0;
  private float upY = 1;
  private float upZ = 0;
  private float angle = 90;
  private float changesY = 0.01f;
  private Cube cube = new Cube();
  private float linex = 0;
  private float liney = 0;
  private float linez = 0;
  private float t =0;
  


  public World() {
  }

  public void init(GLAutoDrawable gld) {
    // get the GL drawing functionality for the canvas
    GL gl = gld.getGL();

    // enable depth testing
    gl.glEnable(GL.GL_DEPTH_TEST);

    // create the animator and attach it to the GL drawing canvas
    theAnimator = new Animator(gld);
    theAnimator.start();


    gl.glShadeModel(GL.GL_SMOOTH);

    // normalize the normals
    gl.glEnable(GL.GL_NORMALIZE);
  }

  public void display(GLAutoDrawable gLAutoDrawable) {
    GL gl = gLAutoDrawable.getGL();


    // change to model-view mode so that we can change camera position
    gl.glMatrixMode(GL.GL_MODELVIEW);

    // clear the model-view matrix ¨C start fresh
    gl.glLoadIdentity();


    gl.glClear(GL.GL_COLOR_BUFFER_BIT |GL.GL_DEPTH_BUFFER_BIT);


    GLU glu = new GLU();

    glu.gluLookAt(eyeX,eyeY,eyeZ,
                  atX,atY,atZ,
                  upX,upY,upZ);


//*****************************start drawing************************************
    gl.glColor3f(0.99f, 0.40f, 0.50f);
    
    gl.glBegin(GL.GL_LINES);
    linex = -20 * 0;
    linex += 10;
    
    liney = -10 * 0;
    liney += 7;
    
    linez = 5 * 0;
    
    gl.glVertex3f(linex, liney, linez);
    t+= 0.0001;
    linex = -20 * t;
    linex += 10;
    
    liney = -10 * t;
    liney += 7;
    
    linez = 5 * t;
    
    gl.glVertex3f(linex, liney, linez);
//    gl.glVertex3f(10, 7, 0);
//    gl.glVertex3f(-10, -3, 5);
    gl.glEnd();
    
    /*
    gl.glColor3f(1, 0, 0);
    gl.glBegin(GL.GL_LINES);
    gl.glVertex3f(0, 0, 0);
    gl.glVertex3f(10, 0, 0);
    gl.glEnd();
    gl.glColor3f(0, 1, 0);
    gl.glBegin(GL.GL_LINES);
    gl.glVertex3f(0, 0, 0);
    gl.glVertex3f(0, 10, 0);
    gl.glEnd();
    gl.glColor3f(0, 0, 1);
    gl.glBegin(GL.GL_LINES);
    gl.glVertex3f(0, 0, 0);
    gl.glVertex3f(0, 0, 10);
    gl.glEnd();
    */
    gl.glColor3f(0.99f, 0.99f, 0.99f);
    cube.drawCube(gl);
    
    gl.glFlush();
//*************************finish drawing***************************************

//****************************for actions***************************************
    eyeX = (float)Math.cos(Math.toRadians(angle))*15;
    eyeZ = (float)Math.sin(Math.toRadians(angle))*15;
    angle++;
    if(Math.abs(eyeY) > 15)
       changesY = -changesY;   eyeY+=changesY;
    
  }



  public void reshape(GLAutoDrawable gld, int _int, int _int2,
                      int width, int height) {
    // get the GL drawing functionality for the canvas
   GLU glu = new GLU();

   // get the GL drawing functionality for the canvas
   GL gl = gld.getGL();

   // change into projection mode to change the camera properties
   gl.glMatrixMode(GL.GL_PROJECTION);

   // load the identity matrix into the projection matrix
   gl.glLoadIdentity();


   glu.gluPerspective(45, (float) width / (float) height, 0.1, 100);

  }

  public void displayChanged(GLAutoDrawable gLAutoDrawable, boolean _boolean,
                             boolean _boolean2) {
  }
}



package com.test.barvnitrikotnik;

import java.io.File;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.math.Rectangle;

public class BarvniTrikotnik implements ApplicationListener{

	private Mesh mesh1,mesh2,mesh3,mesh4;
	private Texture texture;
	//private OrthographicCamera camera;
	private Camera camera;
	//private PerspectiveCamera camera;
	private int total = 0;
	private float movementIncrement = 0.0006f;
	private Music music;

    //@Override
    public void create() {
    	if ((mesh1 == null)&&(mesh2==null)&&(mesh3==null)&&(mesh4==null)) {
            mesh1 = new Mesh(true, 3, 3, 
                    new VertexAttribute(Usage.Position, 3, "a_position"),
                    new VertexAttribute(Usage.ColorPacked, 4, "a_color"),
                    new VertexAttribute(Usage.TextureCoordinates, 2, "a_texCoords"));
            mesh2=new Mesh(true, 3, 3, 
                    new VertexAttribute(Usage.Position, 3, "a_position"),
                    new VertexAttribute(Usage.ColorPacked, 4, "a_color"),
                    new VertexAttribute(Usage.TextureCoordinates, 2, "a_texCoords"));
            mesh3=new Mesh(true, 3, 3, 
                    new VertexAttribute(Usage.Position, 3, "a_position"),
                    new VertexAttribute(Usage.ColorPacked, 4, "a_color"),
                    new VertexAttribute(Usage.TextureCoordinates, 2, "a_texCoords"));
            mesh4=new Mesh(true, 3, 3, 
                    new VertexAttribute(Usage.Position, 3, "a_position"),
                    new VertexAttribute(Usage.ColorPacked, 4, "a_color"),
                    new VertexAttribute(Usage.TextureCoordinates, 2, "a_texCoords"));
            
            
            
            
            //sprednji trikotnik
            mesh1.setVertices(new float[] { -0.4f, -0.4f, 0, Color.toFloatBits(255, 255, 0, 255), 0, 1,
            								0.4f, -0.4f, 0, Color.toFloatBits(255, 255, 0, 255), 1, 1,
            								0, 0.4f,  -0.2f, Color.toFloatBits(255, 255, 0, 255), 0.5f, 0});
            //spodnji trikotnik
            mesh2.setVertices(new float[] { -0.4f, -0.4f, 0, Color.toFloatBits(255, 0, 255, 255), 0, 1,
            								0.4f, -0.4f, 0, Color.toFloatBits(255, 0, 255, 255), 1, 1,
            								0, -0.4f,  -0.4f, Color.toFloatBits(255, 0, 255, 255), 0.5f, 0});
            //desni trikotnik
            mesh3.setVertices(new float[] { 0.4f, -0.4f, 0, Color.toFloatBits(0, 255, 0, 255), 0, 1,
            								0, -0.4f,  -0.4f, Color.toFloatBits(0, 255, 0, 255), 1, 1,
											0, 0.4f,  -0.2f, Color.toFloatBits(0, 255, 0, 255), 0.5f, 0});
            //levi trikotnik
            mesh4.setVertices(new float[] {  0, -0.4f,  -0.4f, Color.toFloatBits(0, 0, 255, 255), 0, 1,
            								-0.4f, -0.4f, 0, Color.toFloatBits(0, 0, 255, 255), 1, 1,
            								0, 0.4f,  -0.2f, Color.toFloatBits(0, 0, 255, 255), 0.5f, 0});
            
                                           
            mesh1.setIndices(new short[] { 0, 1, 2});
            mesh2.setIndices(new short[] { 0, 1, 2});
            mesh3.setIndices(new short[] { 0, 1, 2});
            mesh3.setIndices(new short[] { 0, 1, 2});

            FileHandle imageFileHandle = Gdx.files.internal("data/high-resolution-paper-texture4-256x256.jpg"); 
            texture = new Texture(imageFileHandle);
            
            music = Gdx.audio.newMusic(new FileHandle(new File("C:\\Users\\Blaž\\Downloads\\LADY GAGA - Born This Way (Cover).mp3")));

        }
    }

    //@Override
    public void dispose() { }

    //@Override
    public void pause() { }
    private Rectangle                       glViewport;

    //@Override
    public void render() {
    	handleInput();
    	
    	GL10 gl = Gdx.graphics.getGL10();
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        camera.update();
        camera.apply(gl);
        mesh1.render(GL10.GL_TRIANGLES, 0, 3);
   	 	mesh2.render(GL10.GL_TRIANGLES, 0, 3);
   	 	mesh3.render(GL10.GL_TRIANGLES, 0, 3);
   	 	mesh4.render(GL10.GL_TRIANGLES, 0, 3);

    }

    //@Override
    public void resize(int width, int height) {
    	
    	float aspectRatio = (float) width / (float) width;
    	//camera = new PerspectiveCamera(67, 2f * aspectRatio, 2f);

        camera = new OrthographicCamera(5f * aspectRatio, 5f);
    }

    //@Override
    public void resume() { }
    
    private void handleInput() {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
        	camera.translate(0.1f, 0, 0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
        	camera.translate(-0.1f, 0, 0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
        	camera.translate(0, 0.1f, 0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
        	camera.translate(0, -0.1f, 0);
        }
        	if(Gdx.input.isKeyPressed(Input.Keys.PLUS))
        	{
        		//camera.zoom -= 0.02;
        	}
        	
        	if(Gdx.input.isKeyPressed(Input.Keys.MINUS))
        	{
        		//camera.zoom += 0.02;
        	}
        	
        	if(Gdx.input.isKeyPressed(Input.Keys.NUM_6))
        	{
        		camera.rotate(1, 0, 0.8f, 0);
        	}
        	if(Gdx.input.isKeyPressed(Input.Keys.NUM_4))
        	{
        		camera.rotate(-1, 0, 0.8f, 0);
        	}
        	if(Gdx.input.isKeyPressed(Input.Keys.NUM_2))
        	{
        		camera.rotate(1, 0.8f, 0, 0);
        	}
        	if(Gdx.input.isKeyPressed(Input.Keys.NUM_8))
        	{
        		camera.rotate(-1, 0.8f, 0, 0);
        	}
        	if(Gdx.input.isKeyPressed(Input.Keys.P))
        	{
        		music.play();
        	}
        	if(Gdx.input.isKeyPressed(Input.Keys.S))
        	{
        		music.stop();
        	}
        	if(Gdx.input.isKeyPressed(Input.Keys.U))
        	{
        		music.setVolume(0.4f);
        	}
        	if(Gdx.input.isKeyPressed(Input.Keys.U))
        	{
        		music.setVolume(0.4f);
        	}
        	
        	
        
}

}
    
   
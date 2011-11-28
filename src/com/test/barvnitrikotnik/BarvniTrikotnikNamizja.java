package com.test.barvnitrikotnik;

import com.badlogic.gdx.backends.jogl.JoglApplication;


public class BarvniTrikotnikNamizja 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{

		new JoglApplication(new BarvniTrikotnik(), "Mesh with Color and Texture", 860, 520, false);
 

	}

}

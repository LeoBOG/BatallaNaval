package edu.udistrital.batallanaval.presentacion;

/**
 *   
 *
 * @author Leonardo Orejuela and Leonardo Saenz
 */
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
    
public class Actor {
    protected int x,y;
    protected int width, height;
    protected String spriteName;
    protected Escenario stage;
    protected SpriteCache spriteCache;
    
    public Actor(Escenario stage) {
        this.stage = stage;
        spriteCache = stage.getSpriteCache();
    }
      
    public void paint(Graphics2D g){
        g.drawImage( spriteCache.getSprite(spriteName), x,y, stage );
    }
      
    public int getX(){
        return x;
    }
      
    public void setX(int i){
        x = i;
    }
    
    public int getY(){
        return y;
    }
      
    public void setY(int i){ 
        y = i; 
    }
      
    public String getSpriteName(){
        return spriteName; 
    }
      
    public void setSpriteName(String string) { 
        spriteName = string;
        BufferedImage image = spriteCache.getSprite(spriteName);
        height = image.getHeight();
        width = image.getWidth();
    }     
      
    public int getHeight(){
        return height;
    }
      
    public int getWidth(){
        return width;
    }
     
    public void setHeight(int i){
        height = i;
    }
      
    public void setWidth(int i){ 
        width = i;
    }
    
    public void act(){
    }

    void setOcupado(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

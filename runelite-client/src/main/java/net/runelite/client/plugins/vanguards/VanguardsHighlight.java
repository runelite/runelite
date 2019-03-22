/*    */ package net.runelite.client.plugins.vanguards;
/*    */ 
/*    */ import java.awt.BasicStroke;
/*    */ import java.awt.Color;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.Polygon;
/*    */ import javax.inject.Inject;
/*    */ import net.runelite.api.Client;
/*    */ import net.runelite.api.NPC;
/*    */ import net.runelite.client.ui.overlay.Overlay;
/*    */ import net.runelite.client.ui.overlay.OverlayLayer;
/*    */ import net.runelite.client.ui.overlay.components.PanelComponent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class VanguardsHighlight
/*    */   extends Overlay
/*    */ {
/*    */   private final Client client;
/*    */   private final VanguardsPlugin plugin;
/*    */   private final VanguardsConfig config;
/* 31 */   private final PanelComponent panelComponent = new PanelComponent();
/*    */   
/*    */   @Inject
/*    */   VanguardsHighlight(Client client, VanguardsPlugin plugin, VanguardsConfig config)
/*    */   {
/* 36 */     super(plugin);
/* 37 */     setLayer(OverlayLayer.ABOVE_MAP);
/* 38 */     this.client = client;
/* 39 */     this.plugin = plugin;
/* 40 */     this.config = config;
/*    */   }
/*    */   
/*    */   public Dimension render(Graphics2D graphics) {
/* 44 */     if (!this.plugin.inVangs) {
/* 45 */       return null;
/*    */     }
/* 47 */     if (this.config.showTile()) {
/* 48 */       if (this.plugin.ranger != null) {
/* 49 */         renderNpcOverlay(graphics, this.plugin.ranger, "Range", Color.GREEN);
/*    */       }
/* 51 */       if (this.plugin.mager != null) {
/* 52 */         renderNpcOverlay(graphics, this.plugin.mager, "Mage", Color.BLUE);
/*    */       }
/* 54 */       if (this.plugin.meleer != null) {
/* 55 */         renderNpcOverlay(graphics, this.plugin.meleer, "Melee", Color.RED);
/*    */       }
/*    */     }
/* 58 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   private void renderNpcOverlay(Graphics2D graphics, NPC actor, String name, Color color)
/*    */   {
/* 65 */     Polygon objectClickbox = actor.getConvexHull();
/*    */     
/* 67 */     renderPoly(graphics, color, objectClickbox);
/*    */   }
/*    */   
/*    */ 
/*    */   private void renderPoly(Graphics2D graphics, Color color, Polygon polygon)
/*    */   {
/* 73 */     if (polygon != null)
/*    */     {
/* 75 */       graphics.setColor(color);
/* 76 */       graphics.setStroke(new BasicStroke(2.0F));
/* 77 */       graphics.draw(polygon);
/* 78 */       graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 20));
/* 79 */       graphics.fill(polygon);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Lightsaber\Desktop\lyzrdRl.jar!\net\runelite\client\plugins\vanguards\VanguardsHighlight.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
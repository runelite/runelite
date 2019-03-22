/*    */ package net.runelite.client.plugins.vanguards;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Graphics2D;
/*    */ import java.util.List;
/*    */ import javax.inject.Inject;
/*    */ import net.runelite.api.Client;
/*    */ import net.runelite.client.ui.overlay.Overlay;
/*    */ import net.runelite.client.ui.overlay.OverlayPosition;
/*    */ import net.runelite.client.ui.overlay.components.LineComponent;
/*    */ import net.runelite.client.ui.overlay.components.LineComponent.LineComponentBuilder;
/*    */ import net.runelite.client.ui.overlay.components.PanelComponent;
/*    */ import net.runelite.client.ui.overlay.components.TitleComponent;
/*    */ import net.runelite.client.ui.overlay.components.TitleComponent.TitleComponentBuilder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class VanguardsOverlay
/*    */   extends Overlay
/*    */ {
/*    */   private final Client client;
/*    */   private final VanguardsPlugin plugin;
/*    */   private final VanguardsConfig config;
/* 31 */   private final PanelComponent panelComponent = new PanelComponent();
/*    */   
/*    */   @Inject
/*    */   VanguardsOverlay(Client client, VanguardsPlugin plugin, VanguardsConfig config)
/*    */   {
/* 36 */     super(plugin);
/* 37 */     setPosition(OverlayPosition.DYNAMIC);
/* 38 */     setPosition(OverlayPosition.DETACHED);
/* 39 */     this.client = client;
/* 40 */     this.plugin = plugin;
/* 41 */     this.config = config;
/*    */   }
/*    */   
/*    */   public Dimension render(Graphics2D graphics) {
/* 45 */     if (!this.plugin.inVangs) {
/* 46 */       return null;
/*    */     }
/* 48 */     this.panelComponent.getChildren().clear();
/*    */     
/* 50 */     if (this.config.showHealth()) {
/* 51 */       this.panelComponent.getChildren().add(TitleComponent.builder()
/* 52 */         .text("Vanguards")
/* 53 */         .color(Color.pink)
/* 54 */         .build());
/* 55 */       this.panelComponent.getChildren().add(LineComponent.builder()
/* 56 */         .left("Range")
/* 57 */         .right(Integer.toString(this.plugin.rangeHP))
/* 58 */         .leftColor(Color.green)
/* 59 */         .build());
/* 60 */       this.panelComponent.getChildren().add(LineComponent.builder()
/* 61 */         .left("Mage")
/* 62 */         .right(Integer.toString(this.plugin.mageHP))
/* 63 */         .leftColor(Color.blue)
/* 64 */         .build());
/* 65 */       this.panelComponent.getChildren().add(LineComponent.builder()
/* 66 */         .left("Melee")
/* 67 */         .right(Integer.toString(this.plugin.meleeHP))
/* 68 */         .leftColor(Color.red)
/* 69 */         .build());
/* 70 */       return this.panelComponent.render(graphics);
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 75 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lightsaber\Desktop\lyzrdRl.jar!\net\runelite\client\plugins\vanguards\VanguardsOverlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
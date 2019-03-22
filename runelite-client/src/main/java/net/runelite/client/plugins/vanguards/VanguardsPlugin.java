/*     */ package net.runelite.client.plugins.vanguards;
/*     */ 
/*     */ import com.google.inject.Provides;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.inject.Inject;
/*     */ import net.runelite.api.Client;
/*     */ import net.runelite.api.NPC;
/*     */ import net.runelite.api.Varbits;
/*     */ import net.runelite.api.events.GameTick;
/*     */ import net.runelite.api.events.VarbitChanged;
/*     */ import net.runelite.client.config.ConfigManager;
/*     */ import net.runelite.client.eventbus.Subscribe;
/*     */ import net.runelite.client.plugins.Plugin;
/*     */ import net.runelite.client.plugins.PluginDescriptor;
/*     */ import net.runelite.client.ui.overlay.OverlayManager;
/*     */ 
/*     */ 
/*     */ @PluginDescriptor(name="Vanguards", enabledByDefault=false)
/*     */ public class VanguardsPlugin
/*     */   extends Plugin
/*     */ {
/*  23 */   final int MAGE = 7529;
/*  24 */   final int RANGE = 7528;
/*  25 */   final int MELEE = 7527;
/*  26 */   final int DOWN = 7526;
/*  27 */   public ArrayList<Integer> ids = new ArrayList();
/*     */   public NPC ranger;
/*     */   public NPC mager;
/*     */   public NPC meleer;
/*     */   public boolean inRaid;
/*     */   public boolean magerFound;
/*     */   public boolean rangerFound;
/*     */   public boolean meleeFound;
/*  35 */   public int mageHP = -1;
/*  36 */   public int rangeHP = -1;
/*  37 */   public int meleeHP = -1;
/*     */   
/*     */   public float percent;
/*     */   
/*     */   public boolean inVangs;
/*     */   
/*     */   @Inject
/*     */   private Client client;
/*     */   
/*     */   @Inject
/*     */   private VanguardsConfig config;
/*     */   @Inject
/*     */   private OverlayManager overlayManager;
/*     */   @Inject
/*     */   private VanguardsOverlay overlay;
/*     */   @Inject
/*     */   private VanguardsHighlight highlight;
/*     */   
/*     */   @Provides
/*     */   VanguardsConfig provideConfig(ConfigManager configManager)
/*     */   {
/*  58 */     return (VanguardsConfig)configManager.getConfig(VanguardsConfig.class);
/*     */   }
/*     */   
/*     */ 
/*     */   protected void startUp()
/*     */   {
/*  64 */     this.overlayManager.add(this.overlay);
/*  65 */     this.overlayManager.add(this.highlight);
/*  66 */     this.ids.add(Integer.valueOf(7529));
/*  67 */     this.ids.add(Integer.valueOf(7528));
/*  68 */     this.ids.add(Integer.valueOf(7527));
/*  69 */     this.ids.add(Integer.valueOf(7526));
/*  70 */     this.inRaid = false;
/*  71 */     this.inVangs = false;
/*  72 */     this.meleeFound = false;
/*  73 */     this.rangerFound = false;
/*  74 */     this.magerFound = false;
/*     */   }
/*     */   
/*     */ 
/*     */   protected void shutDown()
/*     */   {
/*  80 */     this.overlayManager.remove(this.overlay);
/*  81 */     this.overlayManager.remove(this.highlight);
/*     */   }
/*     */   
/*     */   @Subscribe
/*     */   public void onGameTick(GameTick tick) {
/*  86 */     if (!this.inRaid) {
/*  87 */       return;
/*     */     }
/*  89 */     List<NPC> npcs = this.client.getNpcs();
/*  90 */     this.inVangs = false;
/*  91 */     for (NPC npc : npcs)
/*     */     {
/*  93 */       if (this.ids.contains(Integer.valueOf(npc.getId())))
/*     */       {
/*     */ 
/*  96 */         this.inVangs = true;
/*  97 */         int currentId = npc.getId();
/*  98 */         switch (currentId) {
/*     */         case 7529: 
/* 100 */           this.percent = (npc.getHealthRatio() / npc.getHealth() * 100.0F);
/* 101 */           this.mageHP = ((int)this.percent);
/* 102 */           this.mager = npc;
/* 103 */           break;
/*     */         case 7528: 
/* 105 */           this.percent = (npc.getHealthRatio() / npc.getHealth() * 100.0F);
/* 106 */           this.rangeHP = ((int)this.percent);
/* 107 */           this.ranger = npc;
/* 108 */           break;
/*     */         case 7527: 
/* 110 */           this.percent = (npc.getHealthRatio() / npc.getHealth() * 100.0F);
/* 111 */           this.meleeHP = ((int)this.percent);
/* 112 */           this.meleer = npc;
/* 113 */           break;
/*     */         case 7526: 
/*     */           
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @Subscribe
/*     */   public void onVarbitChanged(VarbitChanged bit)
/*     */   {
/* 125 */     if (this.client.getVar(Varbits.IN_RAID) == 1) {
/* 126 */       this.inRaid = true;
/*     */     } else {
/* 128 */       this.inRaid = false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Lightsaber\Desktop\lyzrdRl.jar!\net\runelite\client\plugins\vanguards\VanguardsPlugin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
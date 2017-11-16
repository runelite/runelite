import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
@Implements("MilliTimer")
public class MilliTimer extends Timer {
   @ObfuscatedName("os")
   @ObfuscatedGetter(
      intValue = 1732144123
   )
   static int field2117;
   @ObfuscatedName("b")
   long[] field2115;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2141924987
   )
   int field2112;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2008380619
   )
   @Export("sleepTime")
   int sleepTime;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = -189507246416611979L
   )
   @Export("milliTime")
   long milliTime;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1479035195
   )
   int field2118;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1533305935
   )
   int field2111;

   public MilliTimer() {
      this.field2115 = new long[10];
      this.field2112 = 256;
      this.sleepTime = 1;
      this.field2118 = 0;
      this.milliTime = ChatLineBuffer.currentTimeMs();

      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2115[var1] = this.milliTime;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "18922"
   )
   public void vmethod2996() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2115[var1] = 0L;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1469616290"
   )
   public int vmethod2993(int var1, int var2) {
      int var3 = this.field2112;
      int var4 = this.sleepTime;
      this.field2112 = 300;
      this.sleepTime = 1;
      this.milliTime = ChatLineBuffer.currentTimeMs();
      if(0L == this.field2115[this.field2111]) {
         this.field2112 = var3;
         this.sleepTime = var4;
      } else if(this.milliTime > this.field2115[this.field2111]) {
         this.field2112 = (int)((long)(var1 * 2560) / (this.milliTime - this.field2115[this.field2111]));
      }

      if(this.field2112 < 25) {
         this.field2112 = 25;
      }

      if(this.field2112 > 256) {
         this.field2112 = 256;
         this.sleepTime = (int)((long)var1 - (this.milliTime - this.field2115[this.field2111]) / 10L);
      }

      if(this.sleepTime > var1) {
         this.sleepTime = var1;
      }

      this.field2115[this.field2111] = this.milliTime;
      this.field2111 = (this.field2111 + 1) % 10;
      int var5;
      if(this.sleepTime > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2115[var5]) {
               this.field2115[var5] += (long)this.sleepTime;
            }
         }
      }

      if(this.sleepTime < var2) {
         this.sleepTime = var2;
      }

      GZipDecompressor.method3129((long)this.sleepTime);

      for(var5 = 0; this.field2118 < 256; this.field2118 += this.field2112) {
         ++var5;
      }

      this.field2118 &= 255;
      return var5;
   }

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "(Ljc;IIIB)V",
      garbageValue = "8"
   )
   static final void method2936(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.transform();
         }

         if(var0 != null) {
            if(var0.field3611) {
               if(!var0.field3635 || Client.field1015 == var1) {
                  String var4 = var0.name;
                  int var7;
                  int var8;
                  if(var0.combatLevel != 0) {
                     var7 = var0.combatLevel;
                     var8 = class275.localPlayer.combatLevel;
                     int var9 = var8 - var7;
                     String var6;
                     if(var9 < -9) {
                        var6 = class222.getColTags(16711680);
                     } else if(var9 < -6) {
                        var6 = class222.getColTags(16723968);
                     } else if(var9 < -3) {
                        var6 = class222.getColTags(16740352);
                     } else if(var9 < 0) {
                        var6 = class222.getColTags(16756736);
                     } else if(var9 > 9) {
                        var6 = class222.getColTags(65280);
                     } else if(var9 > 6) {
                        var6 = class222.getColTags(4259584);
                     } else if(var9 > 3) {
                        var6 = class222.getColTags(8453888);
                     } else if(var9 > 0) {
                        var6 = class222.getColTags(12648192);
                     } else {
                        var6 = class222.getColTags(16776960);
                     }

                     var4 = var4 + var6 + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3635 && Client.field994) {
                     WorldMapData.addMenuEntry("Examine", class222.getColTags(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.itemSelectionState == 1) {
                     WorldMapData.addMenuEntry("Use", Client.field1001 + " " + "->" + " " + class222.getColTags(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.spellSelected) {
                     if((class28.field387 & 2) == 2) {
                        WorldMapData.addMenuEntry(Client.field1045, Client.field948 + " " + "->" + " " + class222.getColTags(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var10 = var0.field3635 && Client.field994?2000:0;
                     String[] var11 = var0.actions;
                     if(Client.field1018) {
                        var11 = Area.method4292(var11);
                     }

                     if(var11 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var11[var7] != null && !var11[var7].equalsIgnoreCase("Attack")) {
                              var8 = 0;
                              if(var7 == 0) {
                                 var8 = var10 + 9;
                              }

                              if(var7 == 1) {
                                 var8 = var10 + 10;
                              }

                              if(var7 == 2) {
                                 var8 = var10 + 11;
                              }

                              if(var7 == 3) {
                                 var8 = var10 + 12;
                              }

                              if(var7 == 4) {
                                 var8 = var10 + 13;
                              }

                              WorldMapData.addMenuEntry(var11[var7], class222.getColTags(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(var11 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var11[var7] != null && var11[var7].equalsIgnoreCase("Attack")) {
                              short var12 = 0;
                              if(Client.field950 != class90.field1328) {
                                 if(class90.field1322 == Client.field950 || Client.field950 == class90.field1325 && var0.combatLevel > class275.localPlayer.combatLevel) {
                                    var12 = 2000;
                                 }

                                 var8 = 0;
                                 if(var7 == 0) {
                                    var8 = var12 + 9;
                                 }

                                 if(var7 == 1) {
                                    var8 = var12 + 10;
                                 }

                                 if(var7 == 2) {
                                    var8 = var12 + 11;
                                 }

                                 if(var7 == 3) {
                                    var8 = var12 + 12;
                                 }

                                 if(var7 == 4) {
                                    var8 = var12 + 13;
                                 }

                                 WorldMapData.addMenuEntry(var11[var7], class222.getColTags(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3635 || !Client.field994) {
                        WorldMapData.addMenuEntry("Examine", class222.getColTags(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }
}

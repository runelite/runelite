import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jy")
@Implements("Overlay")
public class Overlay extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("overlay_ref")
   static IndexDataBase overlay_ref;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   @Export("overlays")
   static NodeCache overlays;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1122055089
   )
   @Export("color")
   public int color;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1797220547
   )
   @Export("texture")
   public int texture;
   @ObfuscatedName("h")
   @Export("isHidden")
   public boolean isHidden;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -200980065
   )
   @Export("otherRgbColor")
   public int otherRgbColor;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1670004891
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1833550447
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1283902265
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -351171103
   )
   @Export("otherHue")
   public int otherHue;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 442303003
   )
   @Export("otherSaturation")
   public int otherSaturation;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -384475967
   )
   @Export("otherLightness")
   public int otherLightness;

   static {
      overlays = new NodeCache(64);
   }

   Overlay() {
      this.color = 0;
      this.texture = -1;
      this.isHidden = true;
      this.otherRgbColor = -1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1353462303"
   )
   @Export("post")
   void post() {
      if(this.otherRgbColor != -1) {
         this.setHSL(this.otherRgbColor);
         this.otherHue = this.hue;
         this.otherSaturation = this.saturation;
         this.otherLightness = this.lightness;
      }

      this.setHSL(this.color);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lgv;II)V",
      garbageValue = "-628271893"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.readNext(var1, var3, var2);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lgv;III)V",
      garbageValue = "1692822161"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.color = var1.read24BitInt();
      } else if(var2 == 2) {
         this.texture = var1.readUnsignedByte();
      } else if(var2 == 5) {
         this.isHidden = false;
      } else if(var2 == 7) {
         this.otherRgbColor = var1.read24BitInt();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-35"
   )
   @Export("setHSL")
   void setHSL(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var8 + var10) / 2.0D;
      if(var10 != var8) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var10 == var6) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.hue = (int)(var12 * 256.0D);
      this.saturation = (int)(256.0D * var14);
      this.lightness = (int)(256.0D * var16);
      if(this.saturation < 0) {
         this.saturation = 0;
      } else if(this.saturation > 255) {
         this.saturation = 255;
      }

      if(this.lightness < 0) {
         this.lightness = 0;
      } else if(this.lightness > 255) {
         this.lightness = 255;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1699321642"
   )
   @Export("sendConInfo")
   public static void sendConInfo(boolean var0) {
      if(class249.NetCache_socket != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            class249.NetCache_socket.vmethod3166(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class249.NetCache_socket.vmethod3136();
            } catch (Exception var3) {
               ;
            }

            ++class249.field3362;
            class249.NetCache_socket = null;
         }

      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "2136130943"
   )
   static int method4892(int var0, Script var1, boolean var2) {
      if(var0 == 3300) {
         class82.intStack[++class82.intStackSize - 1] = Client.gameCycle;
         return 1;
      } else {
         int var3;
         int var4;
         if(var0 == 3301) {
            class82.intStackSize -= 2;
            var3 = class82.intStack[class82.intStackSize];
            var4 = class82.intStack[class82.intStackSize + 1];
            class82.intStack[++class82.intStackSize - 1] = WidgetNode.method1104(var3, var4);
            return 1;
         } else {
            int[] var5;
            int var6;
            int var7;
            ItemContainer var8;
            if(var0 == 3302) {
               class82.intStackSize -= 2;
               var3 = class82.intStack[class82.intStackSize];
               var4 = class82.intStack[class82.intStackSize + 1];
               var5 = class82.intStack;
               var6 = ++class82.intStackSize - 1;
               var8 = (ItemContainer)ItemContainer.itemContainers.get((long)var3);
               if(var8 == null) {
                  var7 = 0;
               } else if(var4 >= 0 && var4 < var8.stackSizes.length) {
                  var7 = var8.stackSizes[var4];
               } else {
                  var7 = 0;
               }

               var5[var6] = var7;
               return 1;
            } else {
               int var9;
               int var10;
               if(var0 == 3303) {
                  class82.intStackSize -= 2;
                  var3 = class82.intStack[class82.intStackSize];
                  var4 = class82.intStack[class82.intStackSize + 1];
                  var5 = class82.intStack;
                  var6 = ++class82.intStackSize - 1;
                  var8 = (ItemContainer)ItemContainer.itemContainers.get((long)var3);
                  if(var8 == null) {
                     var7 = 0;
                  } else if(var4 == -1) {
                     var7 = 0;
                  } else {
                     var9 = 0;

                     for(var10 = 0; var10 < var8.stackSizes.length; ++var10) {
                        if(var4 == var8.itemIds[var10]) {
                           var9 += var8.stackSizes[var10];
                        }
                     }

                     var7 = var9;
                  }

                  var5[var6] = var7;
                  return 1;
               } else if(var0 == 3304) {
                  var3 = class82.intStack[--class82.intStackSize];
                  class82.intStack[++class82.intStackSize - 1] = FileOnDisk.method2424(var3).size;
                  return 1;
               } else if(var0 == 3305) {
                  var3 = class82.intStack[--class82.intStackSize];
                  class82.intStack[++class82.intStackSize - 1] = Client.boostedSkillLevels[var3];
                  return 1;
               } else if(var0 == 3306) {
                  var3 = class82.intStack[--class82.intStackSize];
                  class82.intStack[++class82.intStackSize - 1] = Client.realSkillLevels[var3];
                  return 1;
               } else if(var0 == 3307) {
                  var3 = class82.intStack[--class82.intStackSize];
                  class82.intStack[++class82.intStackSize - 1] = Client.skillExperiences[var3];
                  return 1;
               } else {
                  int var11;
                  if(var0 == 3308) {
                     var3 = class7.plane;
                     var4 = (GrandExchangeOffer.localPlayer.x >> 7) + class175.baseX;
                     var11 = (GrandExchangeOffer.localPlayer.y >> 7) + GraphicsObject.baseY;
                     class82.intStack[++class82.intStackSize - 1] = (var4 << 14) + var11 + (var3 << 28);
                     return 1;
                  } else if(var0 == 3309) {
                     var3 = class82.intStack[--class82.intStackSize];
                     class82.intStack[++class82.intStackSize - 1] = var3 >> 14 & 16383;
                     return 1;
                  } else if(var0 == 3310) {
                     var3 = class82.intStack[--class82.intStackSize];
                     class82.intStack[++class82.intStackSize - 1] = var3 >> 28;
                     return 1;
                  } else if(var0 == 3311) {
                     var3 = class82.intStack[--class82.intStackSize];
                     class82.intStack[++class82.intStackSize - 1] = var3 & 16383;
                     return 1;
                  } else if(var0 == 3312) {
                     class82.intStack[++class82.intStackSize - 1] = Client.isMembers?1:0;
                     return 1;
                  } else if(var0 == 3313) {
                     class82.intStackSize -= 2;
                     var3 = class82.intStack[class82.intStackSize] + 32768;
                     var4 = class82.intStack[class82.intStackSize + 1];
                     class82.intStack[++class82.intStackSize - 1] = WidgetNode.method1104(var3, var4);
                     return 1;
                  } else if(var0 == 3314) {
                     class82.intStackSize -= 2;
                     var3 = class82.intStack[class82.intStackSize] + 32768;
                     var4 = class82.intStack[class82.intStackSize + 1];
                     var5 = class82.intStack;
                     var6 = ++class82.intStackSize - 1;
                     var8 = (ItemContainer)ItemContainer.itemContainers.get((long)var3);
                     if(var8 == null) {
                        var7 = 0;
                     } else if(var4 >= 0 && var4 < var8.stackSizes.length) {
                        var7 = var8.stackSizes[var4];
                     } else {
                        var7 = 0;
                     }

                     var5[var6] = var7;
                     return 1;
                  } else if(var0 != 3315) {
                     if(var0 == 3316) {
                        if(Client.rights >= 2) {
                           class82.intStack[++class82.intStackSize - 1] = Client.rights;
                        } else {
                           class82.intStack[++class82.intStackSize - 1] = 0;
                        }

                        return 1;
                     } else if(var0 == 3317) {
                        class82.intStack[++class82.intStackSize - 1] = Client.field889;
                        return 1;
                     } else if(var0 == 3318) {
                        class82.intStack[++class82.intStackSize - 1] = Client.world;
                        return 1;
                     } else if(var0 == 3321) {
                        class82.intStack[++class82.intStackSize - 1] = Client.energy;
                        return 1;
                     } else if(var0 == 3322) {
                        class82.intStack[++class82.intStackSize - 1] = Client.weight;
                        return 1;
                     } else if(var0 == 3323) {
                        if(Client.field983) {
                           class82.intStack[++class82.intStackSize - 1] = 1;
                        } else {
                           class82.intStack[++class82.intStackSize - 1] = 0;
                        }

                        return 1;
                     } else if(var0 == 3324) {
                        class82.intStack[++class82.intStackSize - 1] = Client.flags;
                        return 1;
                     } else if(var0 == 3325) {
                        class82.intStackSize -= 4;
                        var3 = class82.intStack[class82.intStackSize];
                        var4 = class82.intStack[class82.intStackSize + 1];
                        var11 = class82.intStack[class82.intStackSize + 2];
                        var6 = class82.intStack[class82.intStackSize + 3];
                        var3 += var4 << 14;
                        var3 += var11 << 28;
                        var3 += var6;
                        class82.intStack[++class82.intStackSize - 1] = var3;
                        return 1;
                     } else {
                        return 2;
                     }
                  } else {
                     class82.intStackSize -= 2;
                     var3 = class82.intStack[class82.intStackSize] + 32768;
                     var4 = class82.intStack[class82.intStackSize + 1];
                     var5 = class82.intStack;
                     var6 = ++class82.intStackSize - 1;
                     var8 = (ItemContainer)ItemContainer.itemContainers.get((long)var3);
                     if(var8 == null) {
                        var7 = 0;
                     } else if(var4 == -1) {
                        var7 = 0;
                     } else {
                        var9 = 0;

                        for(var10 = 0; var10 < var8.stackSizes.length; ++var10) {
                           if(var4 == var8.itemIds[var10]) {
                              var9 += var8.stackSizes[var10];
                           }
                        }

                        var7 = var9;
                     }

                     var5[var6] = var7;
                     return 1;
                  }
               }
            }
         }
      }
   }
}

import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("j")
   public static class182 field2826;
   @ObfuscatedName("x")
   public static class182 field2827;
   @ObfuscatedName("c")
   static NodeCache field2828 = new NodeCache(64);
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -525624361
   )
   public int field2829 = 70;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1424691713
   )
   public int field2833 = 255;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1729430747
   )
   public int field2834 = 255;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -640868215
   )
   public int field2835 = -1;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -274800729
   )
   public int field2836 = 1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -545515971
   )
   public int field2837;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1662332005
   )
   int field2838 = -1;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1974721107
   )
   int field2839 = -1;
   @ObfuscatedName("d")
   static NodeCache field2840 = new NodeCache(64);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 697615963
   )
   public int field2841 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1671472981
   )
   @Export("healthScale")
   public int healthScale = 30;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "84"
   )
   void method3531(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3532(var1, var2);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "103"
   )
   void method3532(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field2833 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field2834 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field2835 = 0;
      } else if(var2 == 5) {
         this.field2829 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field2838 = var1.method2846();
      } else if(var2 == 8) {
         this.field2839 = var1.method2846();
      } else if(var2 == 11) {
         this.field2835 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field2841 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "1844034472"
   )
   public SpritePixels method3533() {
      if(this.field2838 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field2840.get((long)this.field2838);
         if(null != var1) {
            return var1;
         } else {
            var1 = class99.method1997(field2826, this.field2838, 0);
            if(var1 != null) {
               field2840.put(var1, (long)this.field2838);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "1056993014"
   )
   public SpritePixels method3534() {
      if(this.field2839 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field2840.get((long)this.field2839);
         if(null != var1) {
            return var1;
         } else {
            var1 = class99.method1997(field2826, this.field2839, 0);
            if(var1 != null) {
               field2840.put(var1, (long)this.field2839);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)LBufferProvider;",
      garbageValue = "-16777216"
   )
   public static BufferProvider method3547(int var0, int var1, Component var2) {
      try {
         MainBufferProvider var3 = new MainBufferProvider();
         var3.init(var0, var1, var2);
         return var3;
      } catch (Throwable var5) {
         SecondaryBufferProvider var4 = new SecondaryBufferProvider();
         var4.init(var0, var1, var2);
         return var4;
      }
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static final void method3555() {
      for(int var0 = 0; var0 < Client.field353; ++var0) {
         int var1 = Client.field430[var0];
         NPC var2 = Client.cachedNPCs[var1];
         int var3 = Client.secretCipherBuffer2.readUnsignedByte();
         int var4;
         if((var3 & 32) != 0) {
            var2.graphic = Client.secretCipherBuffer2.method2869();
            var4 = Client.secretCipherBuffer2.method2876();
            var2.field666 = var4 >> 16;
            var2.field665 = Client.gameCycle + (var4 & '\uffff');
            var2.field662 = 0;
            var2.field664 = 0;
            if(var2.field665 > Client.gameCycle) {
               var2.field662 = -1;
            }

            if(var2.graphic == '\uffff') {
               var2.graphic = -1;
            }
         }

         int var5;
         int var6;
         int var7;
         if((var3 & 4) != 0) {
            var4 = Client.secretCipherBuffer2.method2860();
            int var8;
            int var9;
            int var10;
            if(var4 > 0) {
               for(var5 = 0; var5 < var4; ++var5) {
                  var7 = -1;
                  var8 = -1;
                  var9 = -1;
                  var6 = Client.secretCipherBuffer2.method3013();
                  if(var6 == 32767) {
                     var6 = Client.secretCipherBuffer2.method3013();
                     var8 = Client.secretCipherBuffer2.method3013();
                     var7 = Client.secretCipherBuffer2.method3013();
                     var9 = Client.secretCipherBuffer2.method3013();
                  } else if(var6 != 32766) {
                     var8 = Client.secretCipherBuffer2.method3013();
                  } else {
                     var6 = -1;
                  }

                  var10 = Client.secretCipherBuffer2.method3013();
                  var2.method609(var6, var8, var7, var9, Client.gameCycle, var10);
               }
            }

            var5 = Client.secretCipherBuffer2.method2860();
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var7 = Client.secretCipherBuffer2.method3013();
                  var8 = Client.secretCipherBuffer2.method3013();
                  if(var8 != 32767) {
                     var9 = Client.secretCipherBuffer2.method3013();
                     var10 = Client.secretCipherBuffer2.readUnsignedByte();
                     int var11 = var8 > 0?Client.secretCipherBuffer2.method2858():var10;
                     var2.method607(var7, Client.gameCycle, var8, var9, var10, var11);
                  } else {
                     var2.method606(var7);
                  }
               }
            }
         }

         if((var3 & 1) != 0) {
            var2.composition = VertexNormal.getNpcDefinition(Client.secretCipherBuffer2.method2949());
            var2.field672 = var2.composition.field3008;
            var2.field678 = var2.composition.field3031;
            var2.field667 = var2.composition.field3033;
            var2.field634 = var2.composition.field3015;
            var2.field635 = var2.composition.field3005;
            var2.field668 = var2.composition.field3017;
            var2.idlePoseAnimation = var2.composition.field3011;
            var2.field684 = var2.composition.field3038;
            var2.field632 = var2.composition.field3019;
         }

         if((var3 & 64) != 0) {
            var4 = Client.secretCipherBuffer2.method2869();
            if(var4 == '\uffff') {
               var4 = -1;
            }

            var5 = Client.secretCipherBuffer2.method2997();
            if(var2.animation == var4 && var4 != -1) {
               var6 = class168.getAnimation(var4).replyMode;
               if(var6 == 1) {
                  var2.actionFrame = 0;
                  var2.field659 = 0;
                  var2.actionAnimationDisable = var5;
                  var2.field629 = 0;
               }

               if(var6 == 2) {
                  var2.field629 = 0;
               }
            } else if(var4 == -1 || var2.animation == -1 || class168.getAnimation(var4).forcedPriority >= class168.getAnimation(var2.animation).forcedPriority) {
               var2.animation = var4;
               var2.actionFrame = 0;
               var2.field659 = 0;
               var2.actionAnimationDisable = var5;
               var2.field629 = 0;
               var2.field636 = var2.field679;
            }
         }

         if((var3 & 2) != 0) {
            var4 = Client.secretCipherBuffer2.method2869();
            var5 = Client.secretCipherBuffer2.method2869();
            var6 = var2.x - 64 * (var4 - CombatInfoListHolder.baseX - CombatInfoListHolder.baseX);
            var7 = var2.y - (var5 - class3.baseY - class3.baseY) * 64;
            if(var6 != 0 || var7 != 0) {
               var2.field653 = (int)(Math.atan2((double)var6, (double)var7) * 325.949D) & 2047;
            }
         }

         if((var3 & 16) != 0) {
            var2.interacting = Client.secretCipherBuffer2.readUnsignedShort();
            if(var2.interacting == '\uffff') {
               var2.interacting = -1;
            }
         }

         if((var3 & 8) != 0) {
            var2.overhead = Client.secretCipherBuffer2.readString();
            var2.field641 = 100;
         }
      }

   }
}

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
public class class22 extends class28 {
   @ObfuscatedName("ps")
   @ObfuscatedGetter(
      intValue = -1976808445
   )
   static int field322;
   @ObfuscatedName("o")
   static int[] field319;
   @ObfuscatedName("aj")
   static java.awt.Font field320;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lgb;Lgb;I)V",
      garbageValue = "-1208095563"
   )
   void method176(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class37.field481.field483) {
         throw new IllegalStateException("");
      } else {
         super.field381 = var2.readUnsignedByte();
         super.field382 = var2.readUnsignedByte();
         super.field379 = var2.readUnsignedShort();
         super.field378 = var2.readUnsignedShort();
         super.field390 = var2.readUnsignedShort();
         super.field385 = var2.readUnsignedShort();
         super.field382 = Math.min(super.field382, 4);
         super.field383 = new short[1][64][64];
         super.field384 = new short[super.field382][64][64];
         super.field389 = new byte[super.field382][64][64];
         super.field386 = new byte[super.field382][64][64];
         super.decorations = new WorldMapDecoration[super.field382][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class36.field477.field474) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            if(var4 == super.field390 && var5 == super.field385) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  for(int var7 = 0; var7 < 64; ++var7) {
                     this.method234(var6, var7, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   public int hashCode() {
      return super.field390 | super.field385 << 8;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class22)) {
         return false;
      } else {
         class22 var2 = (class22)var1;
         return super.field390 == var2.field390 && var2.field385 == super.field385;
      }
   }

   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "([Lig;II)V",
      garbageValue = "1933870798"
   )
   static final void method183(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1) {
            boolean var4;
            if(var3.hasScript) {
               var4 = var3.isHidden;
               if(var4) {
                  continue;
               }
            }

            int var5;
            if(var3.type == 0) {
               if(!var3.hasScript) {
                  var4 = var3.isHidden;
                  if(var4 && var3 != class28.field377) {
                     continue;
                  }
               }

               method183(var0, var3.id);
               if(var3.children != null) {
                  method183(var3.children, var3.id);
               }

               WidgetNode var7 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var7 != null) {
                  var5 = var7.id;
                  if(Script.loadWidget(var5)) {
                     method183(Widget.widgets[var5], -1);
                  }
               }
            }

            if(var3.type == 6) {
               if(var3.field2838 != -1 || var3.field2865 != -1) {
                  var4 = class57.method887(var3);
                  if(var4) {
                     var5 = var3.field2865;
                  } else {
                     var5 = var3.field2838;
                  }

                  if(var5 != -1) {
                     Sequence var6 = class158.getAnimation(var5);

                     for(var3.field2940 += Client.field910; var3.field2940 > var6.frameLenghts[var3.field2939]; GameEngine.method1053(var3)) {
                        var3.field2940 -= var6.frameLenghts[var3.field2939];
                        ++var3.field2939;
                        if(var3.field2939 >= var6.frameIDs.length) {
                           var3.field2939 -= var6.frameStep;
                           if(var3.field2939 < 0 || var3.field2939 >= var6.frameIDs.length) {
                              var3.field2939 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2815 != 0 && !var3.hasScript) {
                  int var8 = var3.field2815 >> 16;
                  var5 = var3.field2815 << 16 >> 16;
                  var8 *= Client.field910;
                  var5 *= Client.field910;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  GameEngine.method1053(var3);
               }
            }
         }
      }

   }
}

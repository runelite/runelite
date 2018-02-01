import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   @Export("SpotAnimationDefinition_modelIndexCache")
   static IndexDataBase SpotAnimationDefinition_modelIndexCache;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   @Export("spotanims")
   public static NodeCache spotanims;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   @Export("SpotAnimationDefinition_cachedModels")
   public static NodeCache SpotAnimationDefinition_cachedModels;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1598841211
   )
   @Export("id")
   int id;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1306763549
   )
   int field3386;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1068363223
   )
   public int field3395;
   @ObfuscatedName("r")
   short[] field3388;
   @ObfuscatedName("m")
   short[] field3396;
   @ObfuscatedName("h")
   short[] field3390;
   @ObfuscatedName("o")
   short[] field3391;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1283758387
   )
   @Export("widthScale")
   int widthScale;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2003328033
   )
   @Export("heightScale")
   int heightScale;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1003644803
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1468618623
   )
   int field3384;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1630731183
   )
   int field3385;

   static {
      spotanims = new NodeCache(64);
      SpotAnimationDefinition_cachedModels = new NodeCache(30);
   }

   Spotanim() {
      this.field3395 = -1;
      this.widthScale = 128;
      this.heightScale = 128;
      this.orientation = 0;
      this.field3384 = 0;
      this.field3385 = 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgj;I)V",
      garbageValue = "-1634760898"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgj;II)V",
      garbageValue = "-435582144"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3386 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3395 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.widthScale = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.heightScale = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.orientation = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field3384 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field3385 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field3388 = new short[var3];
            this.field3396 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3388[var4] = (short)var1.readUnsignedShort();
               this.field3396[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field3390 = new short[var3];
            this.field3391 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3390[var4] = (short)var1.readUnsignedShort();
               this.field3391[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Len;",
      garbageValue = "1881459402"
   )
   @Export("getModel")
   public final Model getModel(int var1) {
      Model var2 = (Model)SpotAnimationDefinition_cachedModels.get((long)this.id);
      if(var2 == null) {
         ModelData var3 = ModelData.method2567(SpotAnimationDefinition_modelIndexCache, this.field3386, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field3388 != null) {
            for(var4 = 0; var4 < this.field3388.length; ++var4) {
               var3.recolor(this.field3388[var4], this.field3396[var4]);
            }
         }

         if(this.field3390 != null) {
            for(var4 = 0; var4 < this.field3390.length; ++var4) {
               var3.method2579(this.field3390[var4], this.field3391[var4]);
            }
         }

         var2 = var3.light(this.field3384 + 64, this.field3385 + 850, -30, -50, -30);
         SpotAnimationDefinition_cachedModels.put(var2, (long)this.id);
      }

      Model var5;
      if(this.field3395 != -1 && var1 != -1) {
         var5 = CacheFile.getAnimation(this.field3395).method4953(var2, var1);
      } else {
         var5 = var2.method2681(true);
      }

      if(this.widthScale != 128 || this.heightScale != 128) {
         var5.scale(this.widthScale, this.heightScale, this.widthScale);
      }

      if(this.orientation != 0) {
         if(this.orientation == 90) {
            var5.rotateY90Ccw();
         }

         if(this.orientation == 180) {
            var5.rotateY90Ccw();
            var5.rotateY90Ccw();
         }

         if(this.orientation == 270) {
            var5.rotateY90Ccw();
            var5.rotateY90Ccw();
            var5.rotateY90Ccw();
         }
      }

      return var5;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "32"
   )
   public static final void method4610() {
      while(true) {
         BoundingBox var0 = (BoundingBox)class7.boundingBoxes.removeLast();
         if(var0 == null) {
            return;
         }

         var0.draw();
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILcd;ZI)I",
      garbageValue = "1569338342"
   )
   static int method4609(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class80.intStack[--class80.intStackSize];
         var3 = class35.getWidget(var4);
      } else {
         var3 = var2?class23.field331:GrandExchangeOffer.field297;
      }

      if(var0 == 1100) {
         class80.intStackSize -= 2;
         var3.scrollX = class80.intStack[class80.intStackSize];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class80.intStack[class80.intStackSize + 1];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         class60.method1015(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class80.intStack[--class80.intStackSize];
         class60.method1015(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.filled = class80.intStack[--class80.intStackSize] == 1;
         class60.method1015(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class80.intStack[--class80.intStackSize];
         class60.method1015(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.lineWidth = class80.intStack[--class80.intStackSize];
         class60.method1015(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.spriteId = class80.intStack[--class80.intStackSize];
         class60.method1015(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.textureId = class80.intStack[--class80.intStackSize];
         class60.method1015(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.spriteTiling = class80.intStack[--class80.intStackSize] == 1;
         class60.method1015(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class80.intStack[--class80.intStackSize];
         class60.method1015(var3);
         return 1;
      } else if(var0 == 1109) {
         class80.intStackSize -= 6;
         var3.field2787 = class80.intStack[class80.intStackSize];
         var3.field2782 = class80.intStack[class80.intStackSize + 1];
         var3.rotationX = class80.intStack[class80.intStackSize + 2];
         var3.rotationZ = class80.intStack[class80.intStackSize + 3];
         var3.rotationY = class80.intStack[class80.intStackSize + 4];
         var3.modelZoom = class80.intStack[class80.intStackSize + 5];
         class60.method1015(var3);
         return 1;
      } else {
         int var9;
         if(var0 == 1110) {
            var9 = class80.intStack[--class80.intStackSize];
            if(var9 != var3.field2785) {
               var3.field2785 = var9;
               var3.field2860 = 0;
               var3.field2871 = 0;
               class60.method1015(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2795 = class80.intStack[--class80.intStackSize] == 1;
            class60.method1015(var3);
            return 1;
         } else if(var0 == 1112) {
            String var8 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
            if(!var8.equals(var3.text)) {
               var3.text = var8;
               class60.method1015(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class80.intStack[--class80.intStackSize];
            class60.method1015(var3);
            return 1;
         } else if(var0 == 1114) {
            class80.intStackSize -= 3;
            var3.field2801 = class80.intStack[class80.intStackSize];
            var3.field2788 = class80.intStack[class80.intStackSize + 1];
            var3.field2800 = class80.intStack[class80.intStackSize + 2];
            class60.method1015(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.textShadowed = class80.intStack[--class80.intStackSize] == 1;
            class60.method1015(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class80.intStack[--class80.intStackSize];
            class60.method1015(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class80.intStack[--class80.intStackSize];
            class60.method1015(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class80.intStack[--class80.intStackSize] == 1;
            class60.method1015(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class80.intStack[--class80.intStackSize] == 1;
            class60.method1015(var3);
            return 1;
         } else if(var0 == 1120) {
            class80.intStackSize -= 2;
            var3.scrollWidth = class80.intStack[class80.intStackSize];
            var3.scrollHeight = class80.intStack[class80.intStackSize + 1];
            class60.method1015(var3);
            if(var4 != -1 && var3.type == 0) {
               class33.method362(FileRequest.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            class80.method1795(var3.id, var3.index);
            Client.field971 = var3;
            class60.method1015(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2805 = class80.intStack[--class80.intStackSize];
            class60.method1015(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2764 = class80.intStack[--class80.intStackSize];
            class60.method1015(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2770 = class80.intStack[--class80.intStackSize];
            class60.method1015(var3);
            return 1;
         } else if(var0 == 1125) {
            var9 = class80.intStack[--class80.intStackSize];
            class307[] var6 = new class307[]{class307.field3863, class307.field3864, class307.field3865, class307.field3866, class307.field3869};
            class307 var7 = (class307)ClanMember.forOrdinal(var6, var9);
            if(var7 != null) {
               var3.field2758 = var7;
               class60.method1015(var3);
            }

            return 1;
         } else if(var0 == 1126) {
            boolean var5 = class80.intStack[--class80.intStackSize] == 1;
            var3.field2772 = var5;
            return 1;
         } else {
            return 2;
         }
      }
   }
}

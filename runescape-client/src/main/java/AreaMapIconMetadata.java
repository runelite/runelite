import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
@Implements("AreaMapIconMetadata")
public class AreaMapIconMetadata {
   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   static Widget field506;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -285687827
   )
   public final int field499;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   public final Coordinates field498;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   public final Coordinates field504;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -212428443
   )
   final int field500;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1089933967
   )
   final int field501;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   final class33 field502;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1999536205
   )
   int field503;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 320467983
   )
   int field497;

   @ObfuscatedSignature(
      signature = "(ILhc;Lhc;Lat;)V"
   )
   AreaMapIconMetadata(int var1, Coordinates var2, Coordinates var3, class33 var4) {
      this.field499 = var1;
      this.field504 = var2;
      this.field498 = var3;
      this.field502 = var4;
      Area var5 = Area.mapAreaType[this.field499];
      SpritePixels var6 = var5.getMapIcon(false);
      if(var6 != null) {
         this.field500 = var6.width;
         this.field501 = var6.height;
      } else {
         this.field500 = 0;
         this.field501 = 0;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1319208550"
   )
   boolean method538(int var1, int var2) {
      return this.method541(var1, var2)?true:this.method540(var1, var2);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1653724597"
   )
   boolean method541(int var1, int var2) {
      Area var3 = Area.mapAreaType[this.field499];
      switch(var3.field3394.field3616) {
      case 0:
         if(var1 > this.field503 - this.field500 && var1 <= this.field503) {
            break;
         }

         return false;
      case 1:
         if(var1 >= this.field503 && var1 < this.field500 + this.field503) {
            break;
         }

         return false;
      case 2:
         if(var1 < this.field503 - this.field500 / 2 || var1 > this.field500 / 2 + this.field503) {
            return false;
         }
      }

      switch(var3.field3388.field3365) {
      case 0:
         if(var2 >= this.field497 && var2 < this.field497 + this.field501) {
            break;
         }

         return false;
      case 1:
         if(var2 <= this.field497 - this.field501 || var2 > this.field497) {
            return false;
         }
         break;
      case 2:
         if(var2 < this.field497 - this.field501 / 2 || var2 > this.field501 / 2 + this.field497) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-877524865"
   )
   boolean method540(int var1, int var2) {
      return this.field502 == null?false:(var1 >= this.field503 - this.field502.field436 / 2 && var1 <= this.field502.field436 / 2 + this.field503?var2 >= this.field497 && var2 <= this.field502.field434 + this.field497:false);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILck;ZB)I",
      garbageValue = "39"
   )
   static int method547(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class82.intStack[--class82.intStackSize];
         var3 = VertexNormal.getWidget(var4);
      } else {
         var3 = var2?class139.field2008:AttackOption.field1306;
      }

      if(var0 == 1100) {
         class82.intStackSize -= 2;
         var3.scrollX = class82.intStack[class82.intStackSize];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class82.intStack[class82.intStackSize + 1];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         class33.method344(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class82.intStack[--class82.intStackSize];
         class33.method344(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.filled = class82.intStack[--class82.intStackSize] == 1;
         class33.method344(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class82.intStack[--class82.intStackSize];
         class33.method344(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.lineWidth = class82.intStack[--class82.intStackSize];
         class33.method344(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.spriteId = class82.intStack[--class82.intStackSize];
         class33.method344(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.textureId = class82.intStack[--class82.intStackSize];
         class33.method344(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.spriteTiling = class82.intStack[--class82.intStackSize] == 1;
         class33.method344(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class82.intStack[--class82.intStackSize];
         class33.method344(var3);
         return 1;
      } else if(var0 == 1109) {
         class82.intStackSize -= 6;
         var3.field2808 = class82.intStack[class82.intStackSize];
         var3.field2809 = class82.intStack[class82.intStackSize + 1];
         var3.rotationX = class82.intStack[class82.intStackSize + 2];
         var3.rotationZ = class82.intStack[class82.intStackSize + 3];
         var3.rotationY = class82.intStack[class82.intStackSize + 4];
         var3.modelZoom = class82.intStack[class82.intStackSize + 5];
         class33.method344(var3);
         return 1;
      } else {
         int var10;
         if(var0 == 1110) {
            var10 = class82.intStack[--class82.intStackSize];
            if(var10 != var3.field2806) {
               var3.field2806 = var10;
               var3.field2881 = 0;
               var3.field2892 = 0;
               class33.method344(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2795 = class82.intStack[--class82.intStackSize] == 1;
            class33.method344(var3);
            return 1;
         } else if(var0 == 1112) {
            String var8 = class82.scriptStringStack[--class35.scriptStringStackSize];
            if(!var8.equals(var3.text)) {
               var3.text = var8;
               class33.method344(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class82.intStack[--class82.intStackSize];
            class33.method344(var3);
            return 1;
         } else if(var0 == 1114) {
            class82.intStackSize -= 3;
            var3.field2814 = class82.intStack[class82.intStackSize];
            var3.field2823 = class82.intStack[class82.intStackSize + 1];
            var3.field2821 = class82.intStack[class82.intStackSize + 2];
            class33.method344(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.textShadowed = class82.intStack[--class82.intStackSize] == 1;
            class33.method344(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class82.intStack[--class82.intStackSize];
            class33.method344(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class82.intStack[--class82.intStackSize];
            class33.method344(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class82.intStack[--class82.intStackSize] == 1;
            class33.method344(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class82.intStack[--class82.intStackSize] == 1;
            class33.method344(var3);
            return 1;
         } else if(var0 == 1120) {
            class82.intStackSize -= 2;
            var3.scrollWidth = class82.intStack[class82.intStackSize];
            var3.scrollHeight = class82.intStack[class82.intStackSize + 1];
            class33.method344(var3);
            if(var4 != -1 && var3.type == 0) {
               GrandExchangeOffer.method102(Widget.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            var10 = var3.id;
            int var6 = var3.index;
            PacketNode var7 = FileSystem.bufferForSize(ClientPacket.field2324, Client.signlink.field1449);
            var7.packetBuffer.writeIntLE(var10);
            var7.packetBuffer.writeShortLE(var6);
            Client.signlink.method1862(var7);
            Client.field958 = var3;
            class33.method344(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2752 = class82.intStack[--class82.intStackSize];
            class33.method344(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2785 = class82.intStack[--class82.intStackSize];
            class33.method344(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2874 = class82.intStack[--class82.intStackSize];
            class33.method344(var3);
            return 1;
         } else if(var0 == 1125) {
            var10 = class82.intStack[--class82.intStackSize];
            class296 var9 = (class296)class91.forOrdinal(class1.method2(), var10);
            if(var9 != null) {
               var3.field2789 = var9;
               class33.method344(var3);
            }

            return 1;
         } else if(var0 == 1126) {
            boolean var5 = class82.intStack[--class82.intStackSize] == 1;
            var3.field2844 = var5;
            return 1;
         } else {
            return 2;
         }
      }
   }

   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      signature = "(Lbo;B)V",
      garbageValue = "-75"
   )
   static final void method546(PendingSpawn var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.type == 0) {
         var1 = class48.region.method2716(var0.level, var0.x, var0.y);
      }

      if(var0.type == 1) {
         var1 = class48.region.method2717(var0.level, var0.x, var0.y);
      }

      if(var0.type == 2) {
         var1 = class48.region.method2718(var0.level, var0.x, var0.y);
      }

      if(var0.type == 3) {
         var1 = class48.region.method2840(var0.level, var0.x, var0.y);
      }

      if(var1 != 0) {
         int var5 = class48.region.getObjectFlags(var0.level, var0.x, var0.y, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field1112 = var2;
      var0.field1114 = var3;
      var0.field1113 = var4;
   }
}

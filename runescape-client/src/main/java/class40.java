import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("aa")
public class class40 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Laa;"
   )
   public static final class40 field561;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Laa;"
   )
   public static final class40 field560;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Laa;"
   )
   public static final class40 field562;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Laa;"
   )
   public static final class40 field568;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Laa;"
   )
   public static final class40 field564;
   @ObfuscatedName("ok")
   @ObfuscatedSignature(
      signature = "Ldk;"
   )
   @Export("soundSystem1")
   static AbstractSoundSystem soundSystem1;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = 1917186815
   )
   static int field569;
   @ObfuscatedName("s")
   public final String field559;

   static {
      field561 = new class40("details");
      field560 = new class40("compositemap");
      field568 = new class40("compositetexture");
      field562 = new class40("area");
      field564 = new class40("labels");
   }

   class40(String var1) {
      this.field559 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "523049883"
   )
   static int method539(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class81.intStack[--class81.intStackSize];
         var3 = PacketBuffer.method3528(var4);
      } else {
         var3 = var2?class81.field1341:class81.field1340;
      }

      if(var0 == 1100) {
         class81.intStackSize -= 2;
         var3.scrollX = class81.intStack[class81.intStackSize];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class81.intStack[class81.intStackSize + 1];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         class25.method172(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class81.intStack[--class81.intStackSize];
         class25.method172(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.field2650 = class81.intStack[--class81.intStackSize] == 1;
         class25.method172(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class81.intStack[--class81.intStackSize];
         class25.method172(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.field2702 = class81.intStack[--class81.intStackSize];
         class25.method172(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.spriteId = class81.intStack[--class81.intStackSize];
         class25.method172(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.textureId = class81.intStack[--class81.intStackSize];
         class25.method172(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.field2696 = class81.intStack[--class81.intStackSize] == 1;
         class25.method172(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class81.intStack[--class81.intStackSize];
         class25.method172(var3);
         return 1;
      } else if(var0 == 1109) {
         class81.intStackSize -= 6;
         var3.field2707 = class81.intStack[class81.intStackSize];
         var3.field2708 = class81.intStack[class81.intStackSize + 1];
         var3.rotationX = class81.intStack[class81.intStackSize + 2];
         var3.rotationZ = class81.intStack[class81.intStackSize + 3];
         var3.rotationY = class81.intStack[class81.intStackSize + 4];
         var3.modelZoom = class81.intStack[class81.intStackSize + 5];
         class25.method172(var3);
         return 1;
      } else {
         int var10;
         if(var0 == 1110) {
            var10 = class81.intStack[--class81.intStackSize];
            if(var10 != var3.field2649) {
               var3.field2649 = var10;
               var3.field2776 = 0;
               var3.field2781 = 0;
               class25.method172(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2715 = class81.intStack[--class81.intStackSize] == 1;
            class25.method172(var3);
            return 1;
         } else if(var0 == 1112) {
            String var8 = class81.scriptStringStack[--class81.scriptStringStackSize];
            if(!var8.equals(var3.text)) {
               var3.text = var8;
               class25.method172(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class81.intStack[--class81.intStackSize];
            class25.method172(var3);
            return 1;
         } else if(var0 == 1114) {
            class81.intStackSize -= 3;
            var3.field2721 = class81.intStack[class81.intStackSize];
            var3.field2722 = class81.intStack[class81.intStackSize + 1];
            var3.field2720 = class81.intStack[class81.intStackSize + 2];
            class25.method172(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.textShadowed = class81.intStack[--class81.intStackSize] == 1;
            class25.method172(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class81.intStack[--class81.intStackSize];
            class25.method172(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class81.intStack[--class81.intStackSize];
            class25.method172(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class81.intStack[--class81.intStackSize] == 1;
            class25.method172(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class81.intStack[--class81.intStackSize] == 1;
            class25.method172(var3);
            return 1;
         } else if(var0 == 1120) {
            class81.intStackSize -= 2;
            var3.scrollWidth = class81.intStack[class81.intStackSize];
            var3.scrollHeight = class81.intStack[class81.intStackSize + 1];
            class25.method172(var3);
            if(var4 != -1 && var3.type == 0) {
               BaseVarType.method17(class177.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            var10 = var3.id;
            int var6 = var3.index;
            Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_ADVANCE_DIALOGUE);
            if(Client.RUNELITE_PACKET) {
               Client.secretPacketBuffer1.runeliteWriteInt(var10);
               Client.secretPacketBuffer1.runeliteWriteInt(var6);
            } else {
               Client.secretPacketBuffer1.putInt(var10);
               Client.secretPacketBuffer1.method3365(var6);
            }

            Client.field1077 = var3;
            class25.method172(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2683 = class81.intStack[--class81.intStackSize];
            class25.method172(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2779 = class81.intStack[--class81.intStackSize];
            class25.method172(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2690 = class81.intStack[--class81.intStackSize];
            class25.method172(var3);
            return 1;
         } else if(var0 == 1125) {
            var10 = class81.intStack[--class81.intStackSize];
            class284[] var9 = new class284[]{class284.field3781, class284.field3779, class284.field3782, class284.field3783, class284.field3784};
            class284 var7 = (class284)class48.forOrdinal(var9, var10);
            if(var7 != null) {
               var3.field2688 = var7;
               class25.method172(var3);
            }

            return 1;
         } else if(var0 == 1126) {
            boolean var5 = class81.intStack[--class81.intStackSize] == 1;
            var3.field2723 = var5;
            return 1;
         } else {
            return 2;
         }
      }
   }
}

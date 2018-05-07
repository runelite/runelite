import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
@Implements("MapIconReference")
public class MapIconReference {
   @ObfuscatedName("pn")
   @ObfuscatedSignature(
      signature = "Ldk;"
   )
   @Export("soundSystem1")
   static AbstractSoundSystem soundSystem1;
   @ObfuscatedName("pp")
   @ObfuscatedGetter(
      intValue = 97023161
   )
   static int field590;
   @ObfuscatedName("r")
   static int[] field588;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = 1986808927
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1245105361
   )
   @Export("areaId")
   public int areaId;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   public Coordinates field586;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   public Coordinates field591;

   @ObfuscatedSignature(
      signature = "(ILio;Lio;)V"
   )
   public MapIconReference(int var1, Coordinates var2, Coordinates var3) {
      this.areaId = var1;
      this.field586 = var2;
      this.field591 = var3;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "-1225648066"
   )
   public static int method761(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }

   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-42"
   )
   static void method759(int var0) {
      if(var0 == -1 && !Client.field1085) {
         class46.method684();
      } else if(var0 != -1 && var0 != Client.field1084 && Client.field1083 != 0 && !Client.field1085) {
         ISAACCipher.method3902(2, class7.indexTrack1, var0, 0, Client.field1083, false);
      }

      Client.field1084 = var0;
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;I)V",
      garbageValue = "-1118013517"
   )
   static void method760(int var0, int var1, int var2, int var3, String var4) {
      Widget var5 = class44.getWidgetChild(var1, var2);
      if(var5 != null) {
         if(var5.onOpListener != null) {
            ScriptEvent var6 = new ScriptEvent();
            var6.source = var5;
            var6.op = var0;
            var6.string = var4;
            var6.params = var5.onOpListener;
            class71.method1203(var6);
         }

         boolean var8 = true;
         if(var5.contentType > 0) {
            var8 = NetWriter.method2140(var5);
         }

         if(var8) {
            if(DecorativeObject.method3163(class1.getWidgetClickMask(var5), var0 - 1)) {
               PacketNode var7;
               if(var0 == 1) {
                  var7 = AbstractSoundSystem.method2350(ClientPacket.field2460, Client.field911.field1460);
                  var7.packetBuffer.putInt(var1);
                  var7.packetBuffer.putShort(var2);
                  var7.packetBuffer.putShort(var3);
                  Client.field911.method2135(var7);
               }

               if(var0 == 2) {
                  var7 = AbstractSoundSystem.method2350(ClientPacket.field2458, Client.field911.field1460);
                  var7.packetBuffer.putInt(var1);
                  var7.packetBuffer.putShort(var2);
                  var7.packetBuffer.putShort(var3);
                  Client.field911.method2135(var7);
               }

               if(var0 == 3) {
                  var7 = AbstractSoundSystem.method2350(ClientPacket.field2386, Client.field911.field1460);
                  var7.packetBuffer.putInt(var1);
                  var7.packetBuffer.putShort(var2);
                  var7.packetBuffer.putShort(var3);
                  Client.field911.method2135(var7);
               }

               if(var0 == 4) {
                  var7 = AbstractSoundSystem.method2350(ClientPacket.field2380, Client.field911.field1460);
                  var7.packetBuffer.putInt(var1);
                  var7.packetBuffer.putShort(var2);
                  var7.packetBuffer.putShort(var3);
                  Client.field911.method2135(var7);
               }

               if(var0 == 5) {
                  var7 = AbstractSoundSystem.method2350(ClientPacket.field2394, Client.field911.field1460);
                  var7.packetBuffer.putInt(var1);
                  var7.packetBuffer.putShort(var2);
                  var7.packetBuffer.putShort(var3);
                  Client.field911.method2135(var7);
               }

               if(var0 == 6) {
                  var7 = AbstractSoundSystem.method2350(ClientPacket.field2461, Client.field911.field1460);
                  var7.packetBuffer.putInt(var1);
                  var7.packetBuffer.putShort(var2);
                  var7.packetBuffer.putShort(var3);
                  Client.field911.method2135(var7);
               }

               if(var0 == 7) {
                  var7 = AbstractSoundSystem.method2350(ClientPacket.field2419, Client.field911.field1460);
                  var7.packetBuffer.putInt(var1);
                  var7.packetBuffer.putShort(var2);
                  var7.packetBuffer.putShort(var3);
                  Client.field911.method2135(var7);
               }

               if(var0 == 8) {
                  var7 = AbstractSoundSystem.method2350(ClientPacket.field2390, Client.field911.field1460);
                  var7.packetBuffer.putInt(var1);
                  var7.packetBuffer.putShort(var2);
                  var7.packetBuffer.putShort(var3);
                  Client.field911.method2135(var7);
               }

               if(var0 == 9) {
                  var7 = AbstractSoundSystem.method2350(ClientPacket.field2455, Client.field911.field1460);
                  var7.packetBuffer.putInt(var1);
                  var7.packetBuffer.putShort(var2);
                  var7.packetBuffer.putShort(var3);
                  Client.field911.method2135(var7);
               }

               if(var0 == 10) {
                  var7 = AbstractSoundSystem.method2350(ClientPacket.field2387, Client.field911.field1460);
                  var7.packetBuffer.putInt(var1);
                  var7.packetBuffer.putShort(var2);
                  var7.packetBuffer.putShort(var3);
                  Client.field911.method2135(var7);
               }

            }
         }
      }
   }

   @ObfuscatedName("jm")
   @ObfuscatedSignature(
      signature = "(Liz;II)I",
      garbageValue = "-2067500032"
   )
   static final int method758(Widget var0, int var1) {
      if(var0.dynamicValues != null && var1 < var0.dynamicValues.length) {
         try {
            int[] var2 = var0.dynamicValues[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = Client.boostedSkillLevels[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = Client.realSkillLevels[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = Client.skillExperiences[var2[var4++]];
               }

               int var9;
               Widget var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = UnitPriceComparator.getWidget(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!NetWriter.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class237.clientVarps[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class248.field3007[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class237.clientVarps[var2[var4++]] * 100 / 46875;
               }

               if(var6 == 8) {
                  var7 = class265.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class248.field3002[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = UnitPriceComparator.getWidget(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!NetWriter.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = Client.energy;
               }

               if(var6 == 12) {
                  var7 = Client.weight;
               }

               if(var6 == 13) {
                  var9 = class237.clientVarps[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = VarCString.getVarbit(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = (class265.localPlayer.x >> 7) + ClientPacket.baseX;
               }

               if(var6 == 19) {
                  var7 = (class265.localPlayer.y >> 7) + baseY;
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && var7 != 0) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }

   @ObfuscatedName("kd")
   @ObfuscatedSignature(
      signature = "(Liz;I)Z",
      garbageValue = "1934268057"
   )
   static boolean method762(Widget var0) {
      return var0.isHidden;
   }
}

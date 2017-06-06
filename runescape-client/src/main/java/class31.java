import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public class class31 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 859082123
   )
   final int field445;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1469130163
   )
   final int field446;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1647150353
   )
   final int field447;
   @ObfuscatedName("cu")
   @Export("indexSoundEffects")
   static IndexData indexSoundEffects;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1251536970"
   )
   static void method262(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class286.field3791 = var1.readUnsignedShort();
      class286.field3793 = new int[class286.field3791];
      class266.field3657 = new int[class286.field3791];
      class233.field3205 = new int[class286.field3791];
      ScriptState.field779 = new int[class286.field3791];
      IndexFile.field2307 = new byte[class286.field3791][];
      var1.offset = var0.length - 7 - class286.field3791 * 8;
      class286.field3790 = var1.readUnsignedShort();
      class286.field3792 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class286.field3791; ++var3) {
         class286.field3793[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class286.field3791; ++var3) {
         class266.field3657[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class286.field3791; ++var3) {
         class233.field3205[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class286.field3791; ++var3) {
         ScriptState.field779[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class286.field3791 * 8 - (var2 - 1) * 3;
      class4.field33 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class4.field33[var3] = var1.read24BitInt();
         if(class4.field33[var3] == 0) {
            class4.field33[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class286.field3791; ++var3) {
         int var4 = class233.field3205[var3];
         int var5 = ScriptState.field779[var3];
         int var6 = var5 * var4;
         byte[] var7 = new byte[var6];
         IndexFile.field2307[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var4 * var10] = var1.readByte();
               }
            }
         }
      }

   }

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "-1945684733"
   )
   static void method263(int var0, String var1) {
      int var2 = class96.field1507;
      int[] var3 = class96.field1508;
      boolean var4 = false;

      for(int var5 = 0; var5 < var2; ++var5) {
         Player var6 = Client.cachedPlayers[var3[var5]];
         if(var6 != null && var6 != World.localPlayer && var6.name != null && var6.name.equalsIgnoreCase(var1)) {
            if(var0 == 1) {
               Client.secretPacketBuffer1.putOpcode(181);
               Client.secretPacketBuffer1.method3166(0);
               Client.secretPacketBuffer1.method3227(var3[var5]);
            } else if(var0 == 4) {
               Client.secretPacketBuffer1.putOpcode(66);
               Client.secretPacketBuffer1.method3132(var3[var5]);
               Client.secretPacketBuffer1.putByte(0);
            } else if(var0 == 6) {
               Client.secretPacketBuffer1.putOpcode(24);
               Client.secretPacketBuffer1.method3227(var3[var5]);
               Client.secretPacketBuffer1.putByte(0);
            } else if(var0 == 7) {
               Client.secretPacketBuffer1.putOpcode(85);
               Client.secretPacketBuffer1.method3166(0);
               Client.secretPacketBuffer1.method3132(var3[var5]);
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         class18.sendGameMessage(4, "", "Unable to find " + var1);
      }

   }

   class31(int var1, int var2, int var3) {
      this.field445 = var1;
      this.field446 = var2;
      this.field447 = var3;
   }
}

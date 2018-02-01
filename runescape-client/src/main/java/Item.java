import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("j")
   @Export("IndexStoreActionHandler_thread")
   static Thread IndexStoreActionHandler_thread;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   public static IndexDataBase field1369;
   @ObfuscatedName("m")
   static int[][] field1371;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 2120471315
   )
   @Export("id")
   int id;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -4340911
   )
   @Export("quantity")
   int quantity;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Len;",
      garbageValue = "-2096748380"
   )
   protected final Model getModel() {
      return CombatInfo1.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "589597554"
   )
   static final void method1922(int var0) {
      short var1 = 256;
      class89.field1313 += var0 * 128;
      int var2;
      if(class89.field1313 > ScriptState.field708.length) {
         class89.field1313 -= ScriptState.field708.length;
         var2 = (int)(Math.random() * 12.0D);
         class33.method360(ScriptState.runeSprites[var2]);
      }

      var2 = 0;
      int var3 = var0 * 128;
      int var4 = (var1 - var0) * 128;

      int var5;
      int var6;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = NetWriter.field1440[var3 + var2] - var0 * ScriptState.field708[var2 + class89.field1313 & ScriptState.field708.length - 1] / 6;
         if(var6 < 0) {
            var6 = 0;
         }

         NetWriter.field1440[var2++] = var6;
      }

      int var7;
      int var8;
      for(var5 = var1 - var0; var5 < var1; ++var5) {
         var6 = var5 * 128;

         for(var7 = 0; var7 < 128; ++var7) {
            var8 = (int)(Math.random() * 100.0D);
            if(var8 < 50 && var7 > 10 && var7 < 118) {
               NetWriter.field1440[var7 + var6] = 255;
            } else {
               NetWriter.field1440[var7 + var6] = 0;
            }
         }
      }

      if(class89.field1311 > 0) {
         class89.field1311 -= var0 * 4;
      }

      if(class89.field1312 > 0) {
         class89.field1312 -= var0 * 4;
      }

      if(class89.field1311 == 0 && class89.field1312 == 0) {
         var5 = (int)(Math.random() * (double)(2000 / var0));
         if(var5 == 0) {
            class89.field1311 = 1024;
         }

         if(var5 == 1) {
            class89.field1312 = 1024;
         }
      }

      for(var5 = 0; var5 < var1 - var0; ++var5) {
         class89.field1340[var5] = class89.field1340[var0 + var5];
      }

      for(var5 = var1 - var0; var5 < var1; ++var5) {
         class89.field1340[var5] = (int)(Math.sin((double)class89.field1310 / 14.0D) * 16.0D + Math.sin((double)class89.field1310 / 15.0D) * 14.0D + Math.sin((double)class89.field1310 / 16.0D) * 12.0D);
         ++class89.field1310;
      }

      class89.field1314 += var0;
      var5 = (var0 + (Client.gameCycle & 1)) / 2;
      if(var5 > 0) {
         for(var6 = 0; var6 < class89.field1314 * 100; ++var6) {
            var7 = (int)(Math.random() * 124.0D) + 2;
            var8 = (int)(Math.random() * 128.0D) + 128;
            NetWriter.field1440[var7 + (var8 << 7)] = 192;
         }

         class89.field1314 = 0;

         int var9;
         for(var6 = 0; var6 < var1; ++var6) {
            var7 = 0;
            var8 = var6 * 128;

            for(var9 = -var5; var9 < 128; ++var9) {
               if(var5 + var9 < 128) {
                  var7 += NetWriter.field1440[var5 + var9 + var8];
               }

               if(var9 - (var5 + 1) >= 0) {
                  var7 -= NetWriter.field1440[var9 + var8 - (var5 + 1)];
               }

               if(var9 >= 0) {
                  Client.field1080[var8 + var9] = var7 / (var5 * 2 + 1);
               }
            }
         }

         for(var6 = 0; var6 < 128; ++var6) {
            var7 = 0;

            for(var8 = -var5; var8 < var1; ++var8) {
               var9 = var8 * 128;
               if(var5 + var8 < var1) {
                  var7 += Client.field1080[var9 + var6 + var5 * 128];
               }

               if(var8 - (var5 + 1) >= 0) {
                  var7 -= Client.field1080[var9 + var6 - (var5 + 1) * 128];
               }

               if(var8 >= 0) {
                  NetWriter.field1440[var9 + var6] = var7 / (var5 * 2 + 1);
               }
            }
         }
      }

   }

   @ObfuscatedName("ke")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1605556164"
   )
   static final void method1921(String var0) {
      if(class234.clanMemberManager != null) {
         PacketNode var1 = class35.method501(ClientPacket.field2333, Client.field867.field1439);
         var1.packetBuffer.putByte(ContextMenuRow.getLength(var0));
         var1.packetBuffer.putString(var0);
         Client.field867.method2021(var1);
      }
   }
}

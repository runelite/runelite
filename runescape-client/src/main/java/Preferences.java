import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("Preferences")
public class Preferences {
   @ObfuscatedName("m")
   @Export("preferences")
   LinkedHashMap preferences;
   @ObfuscatedName("j")
   boolean field1316;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 667083373
   )
   int field1317;
   @ObfuscatedName("i")
   boolean field1318;
   @ObfuscatedName("ku")
   static Widget field1319;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 117307779
   )
   static int field1321;

   Preferences(Buffer var1) {
      this.field1317 = 1;
      this.preferences = new LinkedHashMap();
      if(var1 != null && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field1321) {
            if(var1.readUnsignedByte() == 1) {
               this.field1318 = true;
            }

            if(var2 > 1) {
               this.field1316 = var1.readUnsignedByte() == 1;
            }

            if(var2 > 3) {
               this.field1317 = var1.readUnsignedByte();
            }

            if(var2 > 2) {
               int var3 = var1.readUnsignedByte();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.readInt();
                  int var6 = var1.readInt();
                  this.preferences.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method1566(true);
         }
      } else {
         this.method1566(true);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-538892952"
   )
   void method1566(boolean var1) {
   }

   static {
      field1321 = 4;
   }

   Preferences() {
      this.field1317 = 1;
      this.preferences = new LinkedHashMap();
      this.method1566(true);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)LBuffer;",
      garbageValue = "7623576"
   )
   Buffer method1573() {
      Buffer var1 = new Buffer(100);
      var1.putByte(field1321);
      var1.putByte(this.field1318?1:0);
      var1.putByte(this.field1316?1:0);
      var1.putByte(this.field1317);
      var1.putByte(this.preferences.size());
      Iterator var2 = this.preferences.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.putInt(((Integer)var3.getKey()).intValue());
         var1.putInt(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)V",
      garbageValue = "-83"
   )
   static void method1574(int var0, String var1) {
      int var2 = class96.field1499;
      int[] var3 = class96.field1501;
      boolean var4 = false;

      for(int var5 = 0; var5 < var2; ++var5) {
         Player var6 = Client.cachedPlayers[var3[var5]];
         if(var6 != null && class168.localPlayer != var6 && var6.name != null && var6.name.equalsIgnoreCase(var1)) {
            if(var0 == 1) {
               Client.secretPacketBuffer1.putOpcode(148);
               Client.secretPacketBuffer1.putByte(0);
               Client.secretPacketBuffer1.putShort(var3[var5]);
            } else if(var0 == 4) {
               Client.secretPacketBuffer1.putOpcode(77);
               Client.secretPacketBuffer1.method3183(0);
               Client.secretPacketBuffer1.putShort(var3[var5]);
            } else if(var0 == 6) {
               Client.secretPacketBuffer1.putOpcode(161);
               Client.secretPacketBuffer1.putShort(var3[var5]);
               Client.secretPacketBuffer1.putByte(0);
            } else if(var0 == 7) {
               Client.secretPacketBuffer1.putOpcode(28);
               Client.secretPacketBuffer1.method3183(0);
               Client.secretPacketBuffer1.method3192(var3[var5]);
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         class98.sendGameMessage(4, "", "Unable to find " + var1);
      }

   }
}

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hd")
public class class232 implements class178 {
   @ObfuscatedName("e")
   public static final class232 field3186;
   @ObfuscatedName("q")
   static Widget field3187;
   @ObfuscatedName("c")
   public static final class232 field3188;
   @ObfuscatedName("v")
   public static final class232 field3189;
   @ObfuscatedName("b")
   public static final class232 field3190;
   @ObfuscatedName("y")
   public static final class232 field3191;
   @ObfuscatedName("h")
   public final String field3192;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1678863423
   )
   final int field3193;
   @ObfuscatedName("i")
   public static final class232 field3196;

   static {
      field3196 = new class232("runescape", "RuneScape", 0);
      field3188 = new class232("stellardawn", "Stellar Dawn", 1);
      field3186 = new class232("game3", "Game 3", 2);
      field3189 = new class232("game4", "Game 4", 3);
      field3190 = new class232("game5", "Game 5", 4);
      field3191 = new class232("oldscape", "RuneScape 2007", 5);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class232(String var1, String var2, int var3) {
      this.field3192 = var1;
      this.field3193 = var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-70"
   )
   public int vmethod5009() {
      return this.field3193;
   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "954935029"
   )
   static final void method4102() {
      Client.secretPacketBuffer2.method3389();
      int var0 = Client.secretPacketBuffer2.method3397(8);
      int var1;
      if(var0 < Client.field968) {
         for(var1 = var0; var1 < Client.field968; ++var1) {
            Client.field1076[++Client.field1053 - 1] = Client.field950[var1];
         }
      }

      if(var0 > Client.field968) {
         throw new RuntimeException("");
      } else {
         Client.field968 = 0;

         for(var1 = 0; var1 < var0; ++var1) {
            int var2 = Client.field950[var1];
            NPC var3 = Client.cachedNPCs[var2];
            int var4 = Client.secretPacketBuffer2.method3397(1);
            if(var4 == 0) {
               Client.field950[++Client.field968 - 1] = var2;
               var3.field1276 = Client.gameCycle;
            } else {
               int var5 = Client.secretPacketBuffer2.method3397(2);
               if(var5 == 0) {
                  Client.field950[++Client.field968 - 1] = var2;
                  var3.field1276 = Client.gameCycle;
                  Client.field971[++Client.field970 - 1] = var2;
               } else {
                  int var6;
                  int var7;
                  if(var5 == 1) {
                     Client.field950[++Client.field968 - 1] = var2;
                     var3.field1276 = Client.gameCycle;
                     var6 = Client.secretPacketBuffer2.method3397(3);
                     var3.method1682(var6, (byte)1);
                     var7 = Client.secretPacketBuffer2.method3397(1);
                     if(var7 == 1) {
                        Client.field971[++Client.field970 - 1] = var2;
                     }
                  } else if(var5 == 2) {
                     Client.field950[++Client.field968 - 1] = var2;
                     var3.field1276 = Client.gameCycle;
                     var6 = Client.secretPacketBuffer2.method3397(3);
                     var3.method1682(var6, (byte)2);
                     var7 = Client.secretPacketBuffer2.method3397(3);
                     var3.method1682(var7, (byte)2);
                     int var8 = Client.secretPacketBuffer2.method3397(1);
                     if(var8 == 1) {
                        Client.field971[++Client.field970 - 1] = var2;
                     }
                  } else if(var5 == 3) {
                     Client.field1076[++Client.field1053 - 1] = var2;
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-451678318"
   )
   static void method4103(int var0) {
      Client.field1143 = 0L;
      if(var0 >= 2) {
         Client.isResized = true;
      } else {
         Client.isResized = false;
      }

      int var1 = Client.isResized?2:1;
      if(var1 == 1) {
         Client.field1214.method963(765, 503);
      } else {
         Client.field1214.method963(7680, 2160);
      }

      if(Client.gameState >= 25) {
         class51.method757();
      }

   }
}

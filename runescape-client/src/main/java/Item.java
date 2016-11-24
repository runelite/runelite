import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("qn")
   @ObfuscatedGetter(
      intValue = -1279790273
   )
   static int field882;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 196913731
   )
   @Export("quantity")
   int quantity;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -860528157
   )
   @Export("id")
   int id;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "1672156994"
   )
   protected final Model getModel() {
      return class18.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass166;II)Z",
      garbageValue = "-305940922"
   )
   static boolean method824(class166 var0, int var1) {
      int var2 = var0.method3237(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method3237(1) != 0) {
            method824(var0, var1);
         }

         var3 = var0.method3237(6);
         var4 = var0.method3237(6);
         boolean var12 = var0.method3237(1) == 1;
         if(var12) {
            class45.field909[++class45.field908 - 1] = var1;
         }

         if(null != Client.cachedPlayers[var1]) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field265 = var1;
            if(null != class45.field900[var1]) {
               var6.method230(class45.field900[var1]);
            }

            var6.field646 = class45.field906[var1];
            var6.interacting = class45.field896[var1];
            var7 = class45.field905[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.field625[0] = class45.field901[var1];
            var6.field267 = (byte)var8;
            var6.method234((var9 << 6) + var3 - class16.baseX, var4 + (var10 << 6) - Client.baseY);
            var6.field264 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method3237(2);
         var4 = class45.field905[var1];
         class45.field905[var1] = ((var3 + (var4 >> 28) & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.method3237(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class45.field905[var1];
            var7 = var4 + (var11 >> 28) & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class45.field905[var1] = (var7 << 28) + (var8 << 14) + var9;
            return false;
         } else {
            var3 = var0.method3237(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class45.field905[var1];
            var8 = var4 + (var7 >> 28) & 3;
            var9 = (var7 >> 14) + var5 & 255;
            var10 = var7 + var11 & 255;
            class45.field905[var1] = var10 + (var8 << 28) + (var9 << 14);
            return false;
         }
      }
   }

   @ObfuscatedName("et")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "1560177344"
   )
   static String method825(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.field443 == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.field443 == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.field443 == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.field443 == 5) {
         var0 = var0 + "-wti";
      } else if(Client.field443 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(null != class10.field91) {
         var3 = "/p=" + class10.field91;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.field289 + "/a=" + Client.field290 + var3 + "/";
   }
}

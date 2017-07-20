import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class37 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   public static IndexDataBase field511;
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = -1960459345
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   @Export("indexInterfaces")
   static IndexData indexInterfaces;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1222632427
   )
   static int field505;

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1575289317"
   )
   static final int method492() {
      return Client.menuOptionCount - 1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZI)V",
      garbageValue = "-723544352"
   )
   public static void method488(String var0, boolean var1, boolean var2) {
      class222.method3978(var0, var1, "openjs", var2);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "634400669"
   )
   @Export("getSmoothNoise")
   static final int getSmoothNoise(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class1.getSmoothNoise2D(var3, var5);
      int var8 = class1.getSmoothNoise2D(var3 + 1, var5);
      int var9 = class1.getSmoothNoise2D(var3, var5 + 1);
      int var10 = class1.getSmoothNoise2D(var3 + 1, var5 + 1);
      int var12 = 65536 - Graphics3D.COSINE[var4 * 1024 / var2] >> 1;
      int var11 = ((65536 - var12) * var7 >> 16) + (var8 * var12 >> 16);
      int var14 = 65536 - Graphics3D.COSINE[var4 * 1024 / var2] >> 1;
      int var13 = (var10 * var14 >> 16) + ((65536 - var14) * var9 >> 16);
      int var16 = 65536 - Graphics3D.COSINE[var6 * 1024 / var2] >> 1;
      int var15 = (var13 * var16 >> 16) + ((65536 - var16) * var11 >> 16);
      return var15;
   }

   @ObfuscatedName("ef")
   @ObfuscatedSignature(
      signature = "(Ljc;IIII)V",
      garbageValue = "2131761256"
   )
   static void method491(Sequence var0, int var1, int var2, int var3) {
      if(Client.field935 < 50 && Client.field1035 != 0) {
         if(var0.field3586 != null && var1 < var0.field3586.length) {
            int var4 = var0.field3586[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field1081[Client.field935] = var5;
               Client.field1151[Client.field935] = var6;
               Client.field1010[Client.field935] = 0;
               Client.audioEffects[Client.field935] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field1148[Client.field935] = var7 + (var9 << 8) + (var8 << 16);
               ++Client.field935;
            }
         }
      }
   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "52"
   )
   static final void method493(String var0) {
      if(var0 != null) {
         if((Client.friendCount < 200 || Client.field1026 == 1) && Client.friendCount < 400) {
            String var1 = class215.method3908(var0, class22.field331);
            if(var1 != null) {
               int var2;
               String var4;
               String var5;
               for(var2 = 0; var2 < Client.friendCount; ++var2) {
                  Friend var3 = Client.friends[var2];
                  var4 = class215.method3908(var3.name, class22.field331);
                  if(var4 != null && var4.equals(var1)) {
                     Item.sendGameMessage(30, "", var0 + " is already on your friend list");
                     return;
                  }

                  if(var3.previousName != null) {
                     var5 = class215.method3908(var3.previousName, class22.field331);
                     if(var5 != null && var5.equals(var1)) {
                        Item.sendGameMessage(30, "", var0 + " is already on your friend list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < Client.ignoreCount; ++var2) {
                  Ignore var6 = Client.ignores[var2];
                  var4 = class215.method3908(var6.name, class22.field331);
                  if(var4 != null && var4.equals(var1)) {
                     Item.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                     return;
                  }

                  if(var6.previousName != null) {
                     var5 = class215.method3908(var6.previousName, class22.field331);
                     if(var5 != null && var5.equals(var1)) {
                        Item.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                        return;
                     }
                  }
               }

               if(class215.method3908(class226.localPlayer.name, class22.field331).equals(var1)) {
                  Item.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
               } else {
                  Client.secretPacketBuffer1.putOpcode(133);
                  Client.secretPacketBuffer1.putByte(class15.getLength(var0));
                  Client.secretPacketBuffer1.putString(var0);
               }
            }
         } else {
            Item.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
         }
      }
   }
}

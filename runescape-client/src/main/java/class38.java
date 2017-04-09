import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public class class38 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1910132961
   )
   int field816;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -628699507
   )
   int field817;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -484039885
   )
   int field818;
   @ObfuscatedName("r")
   String field819;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1142336519
   )
   int field820;

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1120037027"
   )
   static final void method764(String var0) {
      if(var0.equalsIgnoreCase("toggleroof")) {
         class148.field2058.field716 = !class148.field2058.field716;
         class150.method2839();
         if(class148.field2058.field716) {
            Player.sendGameMessage(99, "", "Roofs are now all hidden");
         } else {
            Player.sendGameMessage(99, "", "Roofs will only be removed selectively");
         }
      }

      if(var0.equalsIgnoreCase("displayfps")) {
         Client.field318 = !Client.field318;
      }

      if(Client.field470 >= 2) {
         if(var0.equalsIgnoreCase("fpson")) {
            Client.field318 = true;
         }

         if(var0.equalsIgnoreCase("fpsoff")) {
            Client.field318 = false;
         }

         if(var0.equalsIgnoreCase("gc")) {
            System.gc();
         }

         if(var0.equalsIgnoreCase("clientdrop")) {
            class107.method2083();
         }

         if(var0.equalsIgnoreCase("errortest") && Client.field580 == 2) {
            throw new RuntimeException();
         }
      }

      Client.secretCipherBuffer1.putOpcode(138);
      Client.secretCipherBuffer1.putByte(var0.length() + 1);
      Client.secretCipherBuffer1.method2931(var0);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)J",
      garbageValue = "346448520"
   )
   public static long method765(CharSequence var0) {
      long var1 = 0L;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 *= 37L;
         char var5 = var0.charAt(var4);
         if(var5 >= 65 && var5 <= 90) {
            var1 += (long)(var5 + 1 - 65);
         } else if(var5 >= 97 && var5 <= 122) {
            var1 += (long)(var5 + 1 - 97);
         } else if(var5 >= 48 && var5 <= 57) {
            var1 += (long)(var5 + 27 - 48);
         }

         if(var1 >= 177917621779460413L) {
            break;
         }
      }

      while(0L == var1 % 37L && 0L != var1) {
         var1 /= 37L;
      }

      return var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)[LModIcon;",
      garbageValue = "-1937019263"
   )
   static ModIcon[] method766(IndexDataBase var0, int var1, int var2) {
      if(!VertexNormal.method1667(var0, var1, var2)) {
         return null;
      } else {
         ModIcon[] var3 = new ModIcon[class225.field3233];

         for(int var4 = 0; var4 < class225.field3233; ++var4) {
            ModIcon var5 = var3[var4] = new ModIcon();
            var5.width = class225.field3231;
            var5.originalHeight = class146.field2038;
            var5.offsetX = class225.field3230[var4];
            var5.offsetY = ItemComposition.field3003[var4];
            var5.originalWidth = class225.field3232[var4];
            var5.height = ChatLineBuffer.field994[var4];
            var5.palette = class225.field3234;
            var5.pixels = BufferProvider.field3199[var4];
         }

         WidgetNode.method172();
         return var3;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)[LSpritePixels;",
      garbageValue = "-1059918541"
   )
   static SpritePixels[] method767() {
      SpritePixels[] var0 = new SpritePixels[class225.field3233];

      for(int var1 = 0; var1 < class225.field3233; ++var1) {
         SpritePixels var2 = var0[var1] = new SpritePixels();
         var2.maxWidth = class225.field3231;
         var2.maxHeight = class146.field2038;
         var2.offsetX = class225.field3230[var1];
         var2.offsetY = ItemComposition.field3003[var1];
         var2.width = class225.field3232[var1];
         var2.height = ChatLineBuffer.field994[var1];
         int var3 = var2.height * var2.width;
         byte[] var4 = BufferProvider.field3199[var1];
         var2.image = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.image[var5] = class225.field3234[var4[var5] & 255];
         }
      }

      WidgetNode.method172();
      return var0;
   }
}

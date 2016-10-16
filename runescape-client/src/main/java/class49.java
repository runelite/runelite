import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public class class49 extends CacheableNode {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -925364399
   )
   public int field1047;
   @ObfuscatedName("t")
   static NodeCache field1048 = new NodeCache(64);
   @ObfuscatedName("s")
   static class170 field1049;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1217508203
   )
   public int field1050 = 0;
   @ObfuscatedName("g")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1726909507
   )
   public int field1052 = 255;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1810183983
   )
   public int field1053 = 255;
   @ObfuscatedName("z")
   static class170 field1054;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1594876615
   )
   public int field1055 = 1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1439496101
   )
   public int field1056 = 70;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -105645183
   )
   int field1057 = -1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1026935679
   )
   public int field1058 = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1934935111
   )
   public int field1059 = 30;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -92177919
   )
   int field1060 = -1;
   @ObfuscatedName("y")
   static NodeCache field1061 = new NodeCache(64);

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1634736436"
   )
   void method968(Buffer var1) {
      while(true) {
         int var2 = var1.method2481();
         if(var2 == 0) {
            return;
         }

         this.method969(var1, var2);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-34"
   )
   void method969(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.method2668();
      } else if(var2 == 2) {
         this.field1052 = var1.method2481();
      } else if(var2 == 3) {
         this.field1053 = var1.method2481();
      } else if(var2 == 4) {
         this.field1058 = 0;
      } else if(var2 == 5) {
         this.field1056 = var1.method2668();
      } else if(var2 == 6) {
         var1.method2481();
      } else if(var2 == 7) {
         this.field1057 = var1.method2496();
      } else if(var2 == 8) {
         this.field1060 = var1.method2496();
      } else if(var2 == 11) {
         this.field1058 = var1.method2668();
      } else if(var2 == 14) {
         this.field1059 = var1.method2481();
      } else if(var2 == 15) {
         this.field1050 = var1.method2481();
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIII)I",
      garbageValue = "-1337690110"
   )
   static final int method970(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - class94.field1621[1024 * var2 / var3] >> 1;
      return (var0 * (65536 - var4) >> 16) + (var1 * var4 >> 16);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "1933450858"
   )
   public SpritePixels method971() {
      if(this.field1060 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field1061.get((long)this.field1060);
         if(null != var1) {
            return var1;
         } else {
            var1 = class157.method3154(field1054, this.field1060, 0);
            if(null != var1) {
               field1061.put(var1, (long)this.field1060);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "11"
   )
   public SpritePixels method981() {
      if(this.field1057 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field1061.get((long)this.field1057);
         if(null != var1) {
            return var1;
         } else {
            var1 = class157.method3154(field1054, this.field1057, 0);
            if(null != var1) {
               field1061.put(var1, (long)this.field1057);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)[LSpritePixels;",
      garbageValue = "-1998833860"
   )
   static SpritePixels[] method989() {
      SpritePixels[] var0 = new SpritePixels[class52.field1112];

      for(int var1 = 0; var1 < class52.field1112; ++var1) {
         SpritePixels var2 = var0[var1] = new SpritePixels();
         var2.field1439 = class79.field1422;
         var2.field1445 = class79.field1418;
         var2.field1442 = class79.field1419[var1];
         var2.field1447 = XClanMember.field612[var1];
         var2.width = class79.field1420[var1];
         var2.height = class8.field129[var1];
         int var3 = var2.height * var2.width;
         byte[] var4 = class220.field3211[var1];
         var2.image = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.image[var5] = class117.field2002[var4[var5] & 255];
         }
      }

      class23.method571();
      return var0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "0"
   )
   @Export("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class11.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class11.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.method662(var0, var1, var2, var3);
      class11.field168.method3793(var5, (long)var5.id);
      class11.field165.method3840(var5);
      Client.field460 = Client.field453;
   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = -617704797
   )
   static int field1932;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -829167371
   )
   @Export("swColor")
   int swColor;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1295951857
   )
   @Export("seColor")
   int seColor;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 646505167
   )
   @Export("neColor")
   int neColor;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 799884147
   )
   @Export("nwColor")
   int nwColor;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -879620257
   )
   @Export("texture")
   int texture;
   @ObfuscatedName("z")
   @Export("flatShade")
   boolean flatShade;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -546473555
   )
   @Export("rgb")
   int rgb;

   SceneTilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.flatShade = true;
      this.swColor = var1;
      this.seColor = var2;
      this.neColor = var3;
      this.nwColor = var4;
      this.texture = var5;
      this.rgb = var6;
      this.flatShade = var7;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lib;IIB)[Lks;",
      garbageValue = "-114"
   )
   static SpritePixels[] method2685(IndexDataBase var0, int var1, int var2) {
      if(!Parameters.spriteDataValid(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels[] var4 = new SpritePixels[class299.field3866];

         for(int var5 = 0; var5 < class299.field3866; ++var5) {
            SpritePixels var6 = var4[var5] = new SpritePixels();
            var6.maxWidth = class299.field3864;
            var6.maxHeight = class299.field3868;
            var6.offsetX = class299.field3867[var5];
            var6.offsetY = class299.offsetsY[var5];
            var6.width = Item.field1387[var5];
            var6.height = class276.field3727[var5];
            int var7 = var6.width * var6.height;
            byte[] var8 = Bounds.spritePixels[var5];
            var6.pixels = new int[var7];

            for(int var9 = 0; var9 < var7; ++var9) {
               var6.pixels[var9] = FaceNormal.field2025[var8[var9] & 255];
            }
         }

         ContextMenuRow.resetCachedStaticSpriteData();
         return var4;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-682366863"
   )
   public static String method2682(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            var5 = class167.method3158(var5);
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != '.' && var5 != '?' && var5 != '!') {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }

   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "16777215"
   )
   static final void method2683(String var0) {
      if(var0.equalsIgnoreCase("toggleroof")) {
         class2.preferences.hideRoofs = !class2.preferences.hideRoofs;
         WorldComparator.method63();
         if(class2.preferences.hideRoofs) {
            class25.sendGameMessage(99, "", "Roofs are now all hidden");
         } else {
            class25.sendGameMessage(99, "", "Roofs will only be removed selectively");
         }
      }

      if(var0.equalsIgnoreCase("displayfps")) {
         Client.displayFps = !Client.displayFps;
      }

      if(Client.rights >= 2) {
         if(var0.equalsIgnoreCase("aabb")) {
            if(!class7.drawBoundingBoxes3D) {
               class7.drawBoundingBoxes3D = true;
               class7.boundingBox3DDrawMode = class11.BoundingBox3DDrawMode_all;
            } else if(class11.BoundingBox3DDrawMode_all == class7.boundingBox3DDrawMode) {
               class7.drawBoundingBoxes3D = true;
               class7.boundingBox3DDrawMode = class11.BoundingBox3DDrawMode_mouseOver;
            } else {
               class7.drawBoundingBoxes3D = false;
            }
         }

         if(var0.equalsIgnoreCase("fpson")) {
            Client.displayFps = true;
         }

         if(var0.equalsIgnoreCase("fpsoff")) {
            Client.displayFps = false;
         }

         if(var0.equalsIgnoreCase("gc")) {
            System.gc();
         }

         if(var0.equalsIgnoreCase("clientdrop")) {
            TotalQuantityComparator.method85();
         }

         if(var0.equalsIgnoreCase("cs")) {
            class25.sendGameMessage(99, "", "" + Client.field891);
         }

         if(var0.equalsIgnoreCase("errortest") && Client.socketType == 2) {
            throw new RuntimeException();
         }
      }

      PacketNode var1 = FileSystem.bufferForSize(ClientPacket.field2341, Client.field888.field1449);
      var1.packetBuffer.putByte(var0.length() + 1);
      var1.packetBuffer.putString(var0);
      Client.field888.method1862(var1);
   }

   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1202102848"
   )
   static final void method2684() {
      PacketNode var0 = FileSystem.bufferForSize(ClientPacket.field2342, Client.field888.field1449);
      var0.packetBuffer.putByte(0);
      Client.field888.method1862(var0);
   }
}

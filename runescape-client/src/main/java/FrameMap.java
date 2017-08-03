import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("compass")
   static SpritePixels compass;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -336652367
   )
   @Export("id")
   int id;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 229431419
   )
   @Export("count")
   int count;
   @ObfuscatedName("x")
   @Export("types")
   int[] types;
   @ObfuscatedName("y")
   @Export("list")
   int[][] list;

   FrameMap(int var1, byte[] var2) {
      this.id = var1;
      Buffer var3 = new Buffer(var2);
      this.count = var3.readUnsignedByte();
      this.types = new int[this.count];
      this.list = new int[this.count][];

      int var4;
      for(var4 = 0; var4 < this.count; ++var4) {
         this.types[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.count; ++var4) {
         this.list[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.count; ++var4) {
         for(int var5 = 0; var5 < this.list[var4].length; ++var5) {
            this.list[var4][var5] = var3.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfw;Lgc;B)Lgc;",
      garbageValue = "112"
   )
   static final IterableHashTable method2698(Buffer var0, IterableHashTable var1) {
      int var2 = var0.readUnsignedByte();
      int var3;
      if(var1 == null) {
         var3 = WorldMapType1.method249(var2);
         var1 = new IterableHashTable(var3);
      }

      for(var3 = 0; var3 < var2; ++var3) {
         boolean var4 = var0.readUnsignedByte() == 1;
         int var5 = var0.read24BitInt();
         Object var6;
         if(var4) {
            var6 = new ObjectNode(var0.readString());
         } else {
            var6 = new IntegerNode(var0.readInt());
         }

         var1.put((Node)var6, (long)var5);
      }

      return var1;
   }

   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lhn;I)Ljava/lang/String;",
      garbageValue = "-1305163050"
   )
   static String method2697(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               var0 = var0.substring(0, var3) + class174.method3396(class92.method1758(var1, var2 - 1)) + var0.substring(var3 + 2);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var6 = "";
            if(XGrandExchangeOffer.field295 != null) {
               int var5 = XGrandExchangeOffer.field295.field2202;
               String var4 = (var5 >> 24 & 255) + "." + (var5 >> 16 & 255) + "." + (var5 >> 8 & 255) + "." + (var5 & 255);
               var6 = var4;
               if(XGrandExchangeOffer.field295.value != null) {
                  var6 = (String)XGrandExchangeOffer.field295.value;
               }
            }

            var0 = var0.substring(0, var2) + var6 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }
}

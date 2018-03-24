import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
@Implements("PacketNode")
public class PacketNode extends Node {
   @ObfuscatedName("rb")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   @Export("indexStore255")
   static IndexFile indexStore255;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "[Lgd;"
   )
   @Export("packetBufferNodes")
   public static PacketNode[] packetBufferNodes;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2093345173
   )
   public static int field2473;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = 624575755
   )
   static int field2476;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lfo;"
   )
   @Export("clientPacket")
   public ClientPacket clientPacket;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1846115627
   )
   public int field2469;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   @Export("packetBuffer")
   public PacketBuffer packetBuffer;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -3777343
   )
   public int field2470;

   static {
      packetBufferNodes = new PacketNode[300];
      field2473 = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "49"
   )
   public void method3437() {
      if(field2473 < packetBufferNodes.length) {
         packetBufferNodes[++field2473 - 1] = this;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILcj;ZI)I",
      garbageValue = "1763459041"
   )
   static int method3446(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 100) {
         class5.intStackSize -= 3;
         var3 = class81.intStack[class5.intStackSize];
         var4 = class81.intStack[class5.intStackSize + 1];
         int var5 = class81.intStack[class5.intStackSize + 2];
         if(var4 == 0) {
            throw new RuntimeException();
         } else {
            Widget var6 = GZipDecompressor.getWidget(var3);
            if(var6.children == null) {
               var6.children = new Widget[var5 + 1];
            }

            if(var6.children.length <= var5) {
               Widget[] var7 = new Widget[var5 + 1];

               for(int var8 = 0; var8 < var6.children.length; ++var8) {
                  var7[var8] = var6.children[var8];
               }

               var6.children = var7;
            }

            if(var5 > 0 && var6.children[var5 - 1] == null) {
               throw new RuntimeException("" + (var5 - 1));
            } else {
               Widget var12 = new Widget();
               var12.type = var4;
               var12.parentId = var12.id = var6.id;
               var12.index = var5;
               var12.hasScript = true;
               var6.children[var5] = var12;
               if(var2) {
                  class233.field2755 = var12;
               } else {
                  class81.field1260 = var12;
               }

               GameEngine.method1053(var6);
               return 1;
            }
         }
      } else {
         Widget var9;
         if(var0 == 101) {
            var9 = var2?class233.field2755:class81.field1260;
            Widget var10 = GZipDecompressor.getWidget(var9.id);
            var10.children[var9.index] = null;
            GameEngine.method1053(var10);
            return 1;
         } else if(var0 == 102) {
            var9 = GZipDecompressor.getWidget(class81.intStack[--class5.intStackSize]);
            var9.children = null;
            GameEngine.method1053(var9);
            return 1;
         } else if(var0 != 200) {
            if(var0 == 201) {
               var9 = GZipDecompressor.getWidget(class81.intStack[--class5.intStackSize]);
               if(var9 != null) {
                  class81.intStack[++class5.intStackSize - 1] = 1;
                  if(var2) {
                     class233.field2755 = var9;
                  } else {
                     class81.field1260 = var9;
                  }
               } else {
                  class81.intStack[++class5.intStackSize - 1] = 0;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            class5.intStackSize -= 2;
            var3 = class81.intStack[class5.intStackSize];
            var4 = class81.intStack[class5.intStackSize + 1];
            Widget var11 = CollisionData.getWidgetChild(var3, var4);
            if(var11 != null && var4 != -1) {
               class81.intStack[++class5.intStackSize - 1] = 1;
               if(var2) {
                  class233.field2755 = var11;
               } else {
                  class81.field1260 = var11;
               }
            } else {
               class81.intStack[++class5.intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }
}

import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("er")
   @ObfuscatedSignature(
      signature = "Lfs;"
   )
   static class169 field1812;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 138753183
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1654232779
   )
   @Export("x")
   int x;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1040171339
   )
   @Export("y")
   int y;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1081663913
   )
   @Export("renderLevel")
   int renderLevel;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("paint")
   SceneTilePaint paint;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Ldl;"
   )
   @Export("overlay")
   SceneTileModel overlay;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Les;"
   )
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Leh;"
   )
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ldw;"
   )
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Ldo;"
   )
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -546143745
   )
   @Export("entityCount")
   int entityCount;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "[Let;"
   )
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("d")
   @Export("entityFlags")
   int[] entityFlags;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1535032315
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 99522543
   )
   @Export("physicalLevel")
   int physicalLevel;
   @ObfuscatedName("q")
   @Export("draw")
   boolean draw;
   @ObfuscatedName("f")
   @Export("visible")
   boolean visible;
   @ObfuscatedName("j")
   @Export("drawEntities")
   boolean drawEntities;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 989863761
   )
   @Export("wallCullDirection")
   int wallCullDirection;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -82938123
   )
   @Export("wallUncullDirection")
   int wallUncullDirection;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1178380049
   )
   @Export("wallCullOppositeDirection")
   int wallCullOppositeDirection;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -799269623
   )
   @Export("wallDrawFlags")
   int wallDrawFlags;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   @Export("bridge")
   Tile bridge;

   Tile(int var1, int var2, int var3) {
      this.objects = new GameObject[5];
      this.entityFlags = new int[5];
      this.flags = 0;
      this.renderLevel = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;Ljava/io/File;I)V",
      garbageValue = "1613059520"
   )
   static void method2778(File var0, File var1) {
      try {
         FileOnDisk var2 = new FileOnDisk(class167.jagexClDat, "rw", 10000L);
         Buffer var3 = new Buffer(500);
         var3.putByte(3);
         var3.putByte(var1 != null?1:0);
         var3.putCESU8(var0.getPath());
         if(var1 != null) {
            var3.putCESU8("");
         }

         var2.write(var3.payload, 0, var3.offset);
         var2.close();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "1"
   )
   static synchronized void method2779(byte[] var0) {
      if(var0.length == 100 && class195.field2576 < 1000) {
         class195.field2578[++class195.field2576 - 1] = var0;
      } else if(var0.length == 5000 && class195.field2573 < 250) {
         class195.field2575[++class195.field2573 - 1] = var0;
      } else if(var0.length == 30000 && class195.field2574 < 50) {
         class195.field2580[++class195.field2574 - 1] = var0;
      } else {
         if(MilliTimer.field2156 != null) {
            for(int var1 = 0; var1 < class195.field2572.length; ++var1) {
               if(var0.length == class195.field2572[var1] && class195.field2579[var1] < MilliTimer.field2156[var1].length) {
                  MilliTimer.field2156[var1][class195.field2579[var1]++] = var0;
                  return;
               }
            }
         }

      }
   }

   @ObfuscatedName("kn")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)V",
      garbageValue = "0"
   )
   static void method2780(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < ItemComposition.field3643; ++var4) {
         ItemComposition var5 = NetWriter.getItemDefinition(var4);
         if((!var1 || var5.isTradable) && var5.notedTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               WidgetNode.field772 = -1;
               Size.field366 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[var2.length * 2];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      Size.field366 = var2;
      OwnWorldComparator.field846 = 0;
      WidgetNode.field772 = var3;
      String[] var8 = new String[WidgetNode.field772];

      for(int var9 = 0; var9 < WidgetNode.field772; ++var9) {
         var8[var9] = NetWriter.getItemDefinition(var2[var9]).name;
      }

      WorldMapType1.method273(var8, Size.field366);
   }

   @ObfuscatedName("kx")
   @ObfuscatedSignature(
      signature = "(Lgg;B)V",
      garbageValue = "106"
   )
   static void method2777(Buffer var0) {
      if(Client.field1071 != null) {
         var0.putBytes(Client.field1071, 0, Client.field1071.length);
      } else {
         byte[] var1 = Preferences.method1778();
         var0.putBytes(var1, 0, var1.length);
      }
   }
}

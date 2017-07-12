import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class44 extends WorldMapData {
   @ObfuscatedName("cx")
   @Export("indexTrack1")
   static IndexData indexTrack1;
   @ObfuscatedName("c")
   List field606;
   @ObfuscatedName("z")
   HashSet field607;
   @ObfuscatedName("l")
   HashSet field608;
   @ObfuscatedName("cj")
   @Export("indexInterfaces")
   static IndexData indexInterfaces;

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(LBuffer;LBuffer;LBuffer;IZB)V",
      garbageValue = "-103"
   )
   void method645(Buffer var1, Buffer var2, Buffer var3, int var4, boolean var5) {
      this.loadMapData(var1, var4);
      int var6 = var3.readUnsignedShort();
      this.field607 = new HashSet(var6);

      int var7;
      for(var7 = 0; var7 < var6; ++var7) {
         class22 var8 = new class22();

         try {
            var8.method156(var2, var3);
         } catch (IllegalStateException var12) {
            continue;
         }

         this.field607.add(var8);
      }

      var7 = var3.readUnsignedShort();
      this.field608 = new HashSet(var7);

      for(int var13 = 0; var13 < var7; ++var13) {
         class45 var9 = new class45();

         try {
            var9.method655(var2, var3);
         } catch (IllegalStateException var11) {
            continue;
         }

         this.field608.add(var9);
      }

      this.method650(var2, var5);
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(LBuffer;ZI)V",
      garbageValue = "850377935"
   )
   void method650(Buffer var1, boolean var2) {
      this.field606 = new LinkedList();
      int var3 = var1.readUnsignedShort();

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var1.method3130();
         Coordinates var6 = new Coordinates(var1.readInt());
         boolean var7 = var1.readUnsignedByte() == 1;
         if(var2 || !var7) {
            this.field606.add(new class25(var5, var6));
         }
      }

   }

   @ObfuscatedName("eh")
   @ObfuscatedSignature(
      signature = "(I)LRenderOverview;",
      garbageValue = "2074796345"
   )
   static RenderOverview method651() {
      return class43.renderOverview;
   }
}

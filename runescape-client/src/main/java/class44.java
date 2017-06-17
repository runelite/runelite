import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
public class class44 extends WorldMapData {
   @ObfuscatedName("n")
   HashSet field585;
   @ObfuscatedName("a")
   HashSet field586;
   @ObfuscatedName("g")
   List field587;
   @ObfuscatedName("gw")
   static SpritePixels[] field590;

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(LBuffer;LBuffer;LBuffer;IZI)V",
      garbageValue = "1276517586"
   )
   void method604(Buffer var1, Buffer var2, Buffer var3, int var4, boolean var5) {
      this.loadMapData(var1, var4);
      int var6 = var3.readUnsignedShort();
      this.field585 = new HashSet(var6);

      int var7;
      for(var7 = 0; var7 < var6; ++var7) {
         class22 var8 = new class22();

         try {
            var8.method177(var2, var3);
         } catch (IllegalStateException var12) {
            continue;
         }

         this.field585.add(var8);
      }

      var7 = var3.readUnsignedShort();
      this.field586 = new HashSet(var7);

      for(int var13 = 0; var13 < var7; ++var13) {
         class45 var9 = new class45();

         try {
            var9.method609(var2, var3);
         } catch (IllegalStateException var11) {
            continue;
         }

         this.field586.add(var9);
      }

      this.method607(var2, var5);
   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "-1516823564"
   )
   @Export("addMenuEntry")
   public static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      class87.method1599(var0, var1, var2, var3, var4, var5, false);
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(LBuffer;ZB)V",
      garbageValue = "-24"
   )
   void method607(Buffer var1, boolean var2) {
      this.field587 = new LinkedList();
      int var3 = var1.readUnsignedShort();

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var1.method3048();
         Coordinates var6 = new Coordinates(var1.readInt());
         boolean var7 = var1.readUnsignedByte() == 1;
         if(var2 || !var7) {
            this.field587.add(new class25(var5, var6));
         }
      }

   }
}

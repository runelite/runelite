import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public class class44 extends WorldMapData {
   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "[Lkn;"
   )
   @Export("mapDots")
   static SpritePixels[] mapDots;
   @ObfuscatedName("s")
   List field578;
   @ObfuscatedName("l")
   HashSet field580;
   @ObfuscatedName("h")
   HashSet field577;

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(Lfh;ZI)V",
      garbageValue = "-1646627479"
   )
   void method617(Buffer var1, boolean var2) {
      this.field578 = new LinkedList();
      int var3 = var1.readUnsignedShort();

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var1.method3190();
         Coordinates var6 = new Coordinates(var1.readInt());
         boolean var7 = var1.readUnsignedByte() == 1;
         if(var2 || !var7) {
            this.field578.add(new class25(var5, var6));
         }
      }

   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(Lfh;Lfh;Lfh;IZB)V",
      garbageValue = "-39"
   )
   void method616(Buffer var1, Buffer var2, Buffer var3, int var4, boolean var5) {
      this.loadMapData(var1, var4);
      int var6 = var3.readUnsignedShort();
      this.field580 = new HashSet(var6);

      int var7;
      for(var7 = 0; var7 < var6; ++var7) {
         class22 var8 = new class22();

         try {
            var8.method161(var2, var3);
         } catch (IllegalStateException var13) {
            continue;
         }

         this.field580.add(var8);
      }

      var7 = var3.readUnsignedShort();
      this.field577 = new HashSet(var7);

      for(int var11 = 0; var11 < var7; ++var11) {
         class45 var9 = new class45();

         try {
            var9.method625(var2, var3);
         } catch (IllegalStateException var12) {
            continue;
         }

         this.field577.add(var9);
      }

      this.method617(var2, var5);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1089743381"
   )
   static final boolean method615() {
      return class135.field1984;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lit;I)V",
      garbageValue = "250782063"
   )
   public static void method623(IndexDataBase var0) {
      class253.field3387 = var0;
   }

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1672911918"
   )
   static final void method618(int var0, int var1, int var2, int var3) {
      if(Client.cursorState == 1) {
         class182.field2421[Client.field1011 / 100].method5143(Client.field1029 - 8, Client.field1010 - 8);
      }

      if(Client.cursorState == 2) {
         class182.field2421[Client.field1011 / 100 + 4].method5143(Client.field1029 - 8, Client.field1010 - 8);
      }

      class61.method1042();
   }
}

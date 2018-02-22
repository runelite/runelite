import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class44 extends WorldMapData {
   @ObfuscatedName("d")
   HashSet field538;
   @ObfuscatedName("v")
   HashSet field535;
   @ObfuscatedName("s")
   List field534;

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(Lgn;Lgn;Lgn;IZI)V",
      garbageValue = "1215860758"
   )
   void method646(Buffer var1, Buffer var2, Buffer var3, int var4, boolean var5) {
      this.loadMapData(var1, var4);
      int var6 = var3.readUnsignedShort();
      this.field538 = new HashSet(var6);

      int var7;
      for(var7 = 0; var7 < var6; ++var7) {
         class22 var8 = new class22();

         try {
            var8.method175(var2, var3);
         } catch (IllegalStateException var13) {
            continue;
         }

         this.field538.add(var8);
      }

      var7 = var3.readUnsignedShort();
      this.field535 = new HashSet(var7);

      for(int var11 = 0; var11 < var7; ++var11) {
         class45 var9 = new class45();

         try {
            var9.method663(var2, var3);
         } catch (IllegalStateException var12) {
            continue;
         }

         this.field535.add(var9);
      }

      this.method647(var2, var5);
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(Lgn;ZI)V",
      garbageValue = "37043793"
   )
   void method647(Buffer var1, boolean var2) {
      this.field534 = new LinkedList();
      int var3 = var1.readUnsignedShort();

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var1.method3732();
         Coordinates var6 = new Coordinates(var1.readInt());
         boolean var7 = var1.readUnsignedByte() == 1;
         if(var2 || !var7) {
            this.field534.add(new class25(var5, var6));
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "316618954"
   )
   public static int method648(int var0) {
      var0 = (var0 & 1431655765) + (var0 >>> 1 & 1431655765);
      var0 = (var0 >>> 2 & 858993459) + (var0 & 858993459);
      var0 = var0 + (var0 >>> 4) & 252645135;
      var0 += var0 >>> 8;
      var0 += var0 >>> 16;
      return var0 & 255;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lbs;B)V",
      garbageValue = "-57"
   )
   static void method656(World var0) {
      if(var0.method1643() != Client.isMembers) {
         Client.isMembers = var0.method1643();
         class245.method4509(var0.method1643());
      }

      class40.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      class79.port1 = Client.socketType == 0?43594:var0.id + 40000;
      class3.port2 = Client.socketType == 0?443:var0.id + 50000;
      ScriptEvent.myWorldPort = class79.port1;
   }
}

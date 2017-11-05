import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
public class class110 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   @Export("sfx_index")
   IndexDataBase sfx_index;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   @Export("vorbis_index")
   IndexDataBase vorbis_index;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   HashTable field1653;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   HashTable field1654;

   @ObfuscatedSignature(
      signature = "(Lip;Lip;)V"
   )
   public class110(IndexDataBase var1, IndexDataBase var2) {
      this.field1653 = new HashTable(256);
      this.field1654 = new HashTable(256);
      this.sfx_index = var1;
      this.vorbis_index = var2;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II[II)Ldi;",
      garbageValue = "-1888577433"
   )
   class105 method2130(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class105 var7 = (class105)this.field1654.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.getTrack(this.sfx_index, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method1978();
            this.field1654.put(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1600.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II[II)Ldi;",
      garbageValue = "1507688238"
   )
   class105 method2137(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class105 var7 = (class105)this.field1654.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class104 var8 = (class104)this.field1653.get(var5);
         if(var8 == null) {
            var8 = class104.method2000(this.vorbis_index, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1653.put(var8, var5);
         }

         var7 = var8.method2001(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1654.put(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I[IB)Ldi;",
      garbageValue = "1"
   )
   public class105 method2129(int var1, int[] var2) {
      if(this.sfx_index.size() == 1) {
         return this.method2130(0, var1, var2);
      } else if(this.sfx_index.fileCount(var1) == 1) {
         return this.method2130(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I[IB)Ldi;",
      garbageValue = "77"
   )
   public class105 method2132(int var1, int[] var2) {
      if(this.vorbis_index.size() == 1) {
         return this.method2137(0, var1, var2);
      } else if(this.vorbis_index.fileCount(var1) == 1) {
         return this.method2137(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("jm")
   @ObfuscatedSignature(
      signature = "(Lbq;ZB)V",
      garbageValue = "1"
   )
   static final void method2145(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1) {
         class3.method5(var2);
      }

      for(IntegerNode var4 = (IntegerNode)Client.widgetFlags.method3637(); var4 != null; var4 = (IntegerNode)Client.widgetFlags.method3638()) {
         if((long)var2 == (var4.hash >> 48 & 65535L)) {
            var4.unlink();
         }
      }

      Widget var5 = ItemLayer.method2454(var3);
      if(var5 != null) {
         class45.method647(var5);
      }

      class224.method4154();
      if(Client.widgetRoot != -1) {
         PendingSpawn.method1523(Client.widgetRoot, 1);
      }

   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
public class class111 {
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = 1875431817
   )
   @Export("myWorldPort")
   static int myWorldPort;
   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static BuildType field1671;
   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("indexWorldMap")
   static IndexData indexWorldMap;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   @Export("vorbis_index")
   IndexDataBase vorbis_index;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   @Export("sfx_index")
   IndexDataBase sfx_index;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   HashTable field1674;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   HashTable field1672;

   @ObfuscatedSignature(
      signature = "(Lii;Lii;)V"
   )
   public class111(IndexDataBase var1, IndexDataBase var2) {
      this.field1672 = new HashTable(256);
      this.field1674 = new HashTable(256);
      this.sfx_index = var1;
      this.vorbis_index = var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II[IB)Ldp;",
      garbageValue = "-32"
   )
   class106 method2083(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class106 var7 = (class106)this.field1674.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class105 var8 = (class105)this.field1672.get(var5);
         if(var8 == null) {
            var8 = class105.method1977(this.vorbis_index, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1672.put(var8, var5);
         }

         var7 = var8.method1968(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1674.put(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II[II)Ldp;",
      garbageValue = "-1666356885"
   )
   class106 method2093(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class106 var7 = (class106)this.field1674.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.getTrack(this.sfx_index, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method1943();
            this.field1674.put(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1616.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I[IS)Ldp;",
      garbageValue = "255"
   )
   public class106 method2084(int var1, int[] var2) {
      if(this.sfx_index.size() == 1) {
         return this.method2093(0, var1, var2);
      } else if(this.sfx_index.fileCount(var1) == 1) {
         return this.method2093(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I[IB)Ldp;",
      garbageValue = "-71"
   )
   public class106 method2098(int var1, int[] var2) {
      if(this.vorbis_index.size() == 1) {
         return this.method2083(0, var1, var2);
      } else if(this.vorbis_index.fileCount(var1) == 1) {
         return this.method2083(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }
}

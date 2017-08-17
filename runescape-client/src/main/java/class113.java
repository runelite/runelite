import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
public class class113 {
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lfb;"
   )
   public static Buffer field1679;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   @Export("vorbis_index")
   IndexDataBase vorbis_index;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   @Export("sfx_index")
   IndexDataBase sfx_index;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   XHashTable field1675;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   XHashTable field1674;

   @ObfuscatedSignature(
      signature = "(Lia;Lia;)V"
   )
   public class113(IndexDataBase var1, IndexDataBase var2) {
      this.field1674 = new XHashTable(256);
      this.field1675 = new XHashTable(256);
      this.sfx_index = var1;
      this.vorbis_index = var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II[II)Lde;",
      garbageValue = "-845315323"
   )
   class108 method2105(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class108 var7 = (class108)this.field1675.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.getTrack(this.sfx_index, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method1961();
            this.field1675.put(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1618.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II[IS)Lde;",
      garbageValue = "238"
   )
   class108 method2117(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class108 var7 = (class108)this.field1675.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class107 var8 = (class107)this.field1674.get(var5);
         if(var8 == null) {
            var8 = class107.method1986(this.vorbis_index, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1674.put(var8, var5);
         }

         var7 = var8.method1974(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1675.put(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I[II)Lde;",
      garbageValue = "203473263"
   )
   public class108 method2107(int var1, int[] var2) {
      if(this.sfx_index.size() == 1) {
         return this.method2105(0, var1, var2);
      } else if(this.sfx_index.fileCount(var1) == 1) {
         return this.method2105(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I[II)Lde;",
      garbageValue = "707506615"
   )
   public class108 method2108(int var1, int[] var2) {
      if(this.vorbis_index.size() == 1) {
         return this.method2117(0, var1, var2);
      } else if(this.vorbis_index.fileCount(var1) == 1) {
         return this.method2117(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }
}

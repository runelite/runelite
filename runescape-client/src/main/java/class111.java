import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
public class class111 {
   @ObfuscatedName("ni")
   @Export("clanChatRank")
   static byte clanChatRank;
   @ObfuscatedName("fg")
   static byte[][] field1578;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("sfx_index")
   IndexDataBase sfx_index;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("vorbis_index")
   IndexDataBase vorbis_index;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   HashTable field1576;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   HashTable field1581;

   @ObfuscatedSignature(
      signature = "(Lij;Lij;)V"
   )
   public class111(IndexDataBase var1, IndexDataBase var2) {
      this.field1576 = new HashTable(256);
      this.field1581 = new HashTable(256);
      this.sfx_index = var1;
      this.vorbis_index = var2;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II[II)Ldn;",
      garbageValue = "-1815450701"
   )
   class106 method2099(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class106 var7 = (class106)this.field1581.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.getTrack(this.sfx_index, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method1936();
            this.field1581.put(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1519.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II[IS)Ldn;",
      garbageValue = "30842"
   )
   class106 method2097(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class106 var7 = (class106)this.field1581.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class105 var8 = (class105)this.field1576.get(var5);
         if(var8 == null) {
            var8 = class105.method1960(this.vorbis_index, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1576.put(var8, var5);
         }

         var7 = var8.method1968(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1581.put(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I[IS)Ldn;",
      garbageValue = "-19547"
   )
   public class106 method2105(int var1, int[] var2) {
      if(this.sfx_index.size() == 1) {
         return this.method2099(0, var1, var2);
      } else if(this.sfx_index.fileCount(var1) == 1) {
         return this.method2099(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I[II)Ldn;",
      garbageValue = "404574868"
   )
   public class106 method2100(int var1, int[] var2) {
      if(this.vorbis_index.size() == 1) {
         return this.method2097(0, var1, var2);
      } else if(this.vorbis_index.fileCount(var1) == 1) {
         return this.method2097(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "1792741270"
   )
   static char method2096(char var0) {
      return (char)(var0 == 198?69:(var0 == 230?101:(var0 == 223?115:(var0 == 338?69:(var0 == 339?'e':'\u0000')))));
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2005990494"
   )
   static final int method2106(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
public class class111 {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("sfx_index")
   IndexDataBase sfx_index;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("vorbis_index")
   IndexDataBase vorbis_index;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   HashTable field1580;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   HashTable field1578;

   @ObfuscatedSignature(
      signature = "(Lil;Lil;)V"
   )
   public class111(IndexDataBase var1, IndexDataBase var2) {
      this.field1580 = new HashTable(256);
      this.field1578 = new HashTable(256);
      this.sfx_index = var1;
      this.vorbis_index = var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II[II)Ldp;",
      garbageValue = "113203175"
   )
   class106 method2135(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class106 var7 = (class106)this.field1578.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.getTrack(this.sfx_index, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method1986();
            this.field1578.put(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1522.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II[II)Ldp;",
      garbageValue = "-95673806"
   )
   class106 method2134(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class106 var7 = (class106)this.field1578.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class105 var8 = (class105)this.field1580.get(var5);
         if(var8 == null) {
            var8 = class105.method2028(this.vorbis_index, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1580.put(var8, var5);
         }

         var7 = var8.method2010(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1578.put(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I[II)Ldp;",
      garbageValue = "849016671"
   )
   public class106 method2137(int var1, int[] var2) {
      if(this.sfx_index.size() == 1) {
         return this.method2135(0, var1, var2);
      } else if(this.sfx_index.fileCount(var1) == 1) {
         return this.method2135(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I[II)Ldp;",
      garbageValue = "978230848"
   )
   public class106 method2136(int var1, int[] var2) {
      if(this.vorbis_index.size() == 1) {
         return this.method2134(0, var1, var2);
      } else if(this.vorbis_index.fileCount(var1) == 1) {
         return this.method2134(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Throwable;B)Ljava/lang/String;",
      garbageValue = "-66"
   )
   static String method2149(Throwable var0) throws IOException {
      String var1;
      if(var0 instanceof RunException) {
         RunException var2 = (RunException)var0;
         var1 = var2.field2136 + " | ";
         var0 = var2.field2139;
      } else {
         var1 = "";
      }

      StringWriter var12 = new StringWriter();
      PrintWriter var3 = new PrintWriter(var12);
      var0.printStackTrace(var3);
      var3.close();
      String var4 = var12.toString();
      BufferedReader var5 = new BufferedReader(new StringReader(var4));
      String var6 = var5.readLine();

      while(true) {
         while(true) {
            String var7 = var5.readLine();
            if(var7 == null) {
               var1 = var1 + "| " + var6;
               return var1;
            }

            int var8 = var7.indexOf(40);
            int var9 = var7.indexOf(41, var8 + 1);
            if(var8 >= 0 && var9 >= 0) {
               String var10 = var7.substring(var8 + 1, var9);
               int var11 = var10.indexOf(".java:");
               if(var11 >= 0) {
                  var10 = var10.substring(0, var11) + var10.substring(var11 + 5);
                  var1 = var1 + var10 + ' ';
                  continue;
               }

               var7 = var7.substring(0, var8);
            }

            var7 = var7.trim();
            var7 = var7.substring(var7.lastIndexOf(32) + 1);
            var7 = var7.substring(var7.lastIndexOf(9) + 1);
            var1 = var1 + var7 + ' ';
         }
      }
   }
}

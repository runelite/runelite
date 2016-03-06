import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ae")
public class class44 extends class203 {
   @ObfuscatedName("b")
   public boolean field1023 = false;
   @ObfuscatedName("l")
   public static class166 field1024;
   @ObfuscatedName("m")
   int[] field1025;
   @ObfuscatedName("i")
   public static class192 field1026 = new class192(64);
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -695596241
   )
   public int field1027 = -1;
   @ObfuscatedName("h")
   short[] field1028;
   @ObfuscatedName("o")
   short[] field1029;
   @ObfuscatedName("j")
   public static class166 field1030;
   @ObfuscatedName("n")
   short[] field1031;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 791723521
   )
   public static int field1032;
   @ObfuscatedName("r")
   int[] field1033 = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("k")
   short[] field1034;

   @ObfuscatedName("a")
   void method916(class118 var1, int var2) {
      if(var2 == 1) {
         this.field1027 = var1.method2453();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.method2453();
            this.field1025 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1025[var4] = var1.method2455();
            }
         } else if(var2 == 3) {
            this.field1023 = true;
         } else if(var2 == 40) {
            var3 = var1.method2453();
            this.field1029 = new short[var3];
            this.field1028 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1029[var4] = (short)var1.method2455();
               this.field1028[var4] = (short)var1.method2455();
            }
         } else if(var2 == 41) {
            var3 = var1.method2453();
            this.field1031 = new short[var3];
            this.field1034 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1031[var4] = (short)var1.method2455();
               this.field1034[var4] = (short)var1.method2455();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field1033[var2 - 60] = var1.method2455();
         }
      }

   }

   @ObfuscatedName("i")
   public boolean method917() {
      if(null == this.field1025) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field1025.length; ++var2) {
            if(!field1024.method3216(this.field1025[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("f")
   public class99 method918() {
      if(this.field1025 == null) {
         return null;
      } else {
         class99[] var1 = new class99[this.field1025.length];

         for(int var2 = 0; var2 < this.field1025.length; ++var2) {
            var1[var2] = class99.method2237(field1024, this.field1025[var2], 0);
         }

         class99 var4;
         if(var1.length == 1) {
            var4 = var1[0];
         } else {
            var4 = new class99(var1, var1.length);
         }

         int var3;
         if(this.field1029 != null) {
            for(var3 = 0; var3 < this.field1029.length; ++var3) {
               var4.method2189(this.field1029[var3], this.field1028[var3]);
            }
         }

         if(this.field1031 != null) {
            for(var3 = 0; var3 < this.field1031.length; ++var3) {
               var4.method2183(this.field1031[var3], this.field1034[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("m")
   public boolean method919() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.field1033[var2] != -1 && !field1024.method3216(this.field1033[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("o")
   public class99 method920() {
      class99[] var1 = new class99[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(-1 != this.field1033[var3]) {
            var1[var2++] = class99.method2237(field1024, this.field1033[var3], 0);
         }
      }

      class99 var5 = new class99(var1, var2);
      int var4;
      if(null != this.field1029) {
         for(var4 = 0; var4 < this.field1029.length; ++var4) {
            var5.method2189(this.field1029[var4], this.field1028[var4]);
         }
      }

      if(this.field1031 != null) {
         for(var4 = 0; var4 < this.field1031.length; ++var4) {
            var5.method2183(this.field1031[var4], this.field1034[var4]);
         }
      }

      return var5;
   }

   @ObfuscatedName("l")
   void method926(class118 var1) {
      while(true) {
         int var2 = var1.method2453();
         if(var2 == 0) {
            return;
         }

         this.method916(var1, var2);
      }
   }

   @ObfuscatedName("l")
   static void method934(int var0, String var1, String var2, String var3) {
      class27 var4 = (class27)class11.field174.get(Integer.valueOf(var0));
      if(null == var4) {
         var4 = new class27();
         class11.field174.put(Integer.valueOf(var0), var4);
      }

      class35 var5 = var4.method639(var0, var1, var2, var3);
      class11.field172.method3760(var5, (long)var5.field789);
      class11.field173.method3799(var5);
      client.field480 = client.field392;
   }

   @ObfuscatedName("cs")
   static final void method939(int var0) {
      if(class149.method3102(var0)) {
         class172[] var1 = class172.field2757[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            class172 var3 = var1[var2];
            if(null != var3) {
               var3.field2816 = 0;
               var3.field2760 = 0;
            }
         }

      }
   }

   @ObfuscatedName("l")
   static File method940(String var0) {
      if(!class134.field2087) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class134.field2084.get(var0);
         if(null != var1) {
            return var1;
         } else {
            File var2 = new File(class134.field2083, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class134.field2084.put(var0, var2);
                  return var2;
               }
            } catch (Exception var7) {
               try {
                  if(null != var3) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var6) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }
}

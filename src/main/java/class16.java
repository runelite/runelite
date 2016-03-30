import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public final class class16 extends class208 {
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = 1103704357
   )
   @Export("cameraYaw")
   static int field237;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 389682841
   )
   int field238;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -489754325
   )
   int field239;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 327390955
   )
   int field240;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1819724557
   )
   int field241;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -613303229
   )
   int field242;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1407445313
   )
   int field243;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -690292853
   )
   int field245;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 903916347
   )
   int field246 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1838727367
   )
   int field247 = -1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 627822161
   )
   int field249;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -2078627521
   )
   int field250;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1317775345
   )
   int field251;
   @ObfuscatedName("qz")
   @ObfuscatedGetter(
      intValue = -179818819
   )
   protected static int field252;

   @ObfuscatedName("x")
   public static File method180(String var0) {
      if(!class135.field2100) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class135.field2095.get(var0);
         if(null != var1) {
            return var1;
         } else {
            File var2 = new File(class135.field2096, var0);
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
                  class135.field2095.put(var0, var2);
                  return var2;
               }
            } catch (Exception var7) {
               try {
                  if(var3 != null) {
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

   @ObfuscatedName("l")
   public static class80 method181(class167 var0, int var1) {
      return !class109.method2427(var0, var1)?null:class136.method2901();
   }

   @ObfuscatedName("af")
   static final void method182() {
      for(int var0 = 0; var0 < client.field332; ++var0) {
         int var1 = client.field333[var0];
         class34 var2 = client.field331[var1];
         if(var2 != null) {
            class40.method873(var2);
         }
      }

   }

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-20"
   )
   static final void method183(String var0) {
      if(var0 != null) {
         String var1 = class142.method2997(var0, class164.field2678);
         if(var1 != null) {
            for(int var2 = 0; var2 < client.field565; ++var2) {
               class7 var3 = client.field566[var2];
               String var4 = var3.field146;
               String var5 = class142.method2997(var4, class164.field2678);
               boolean var6;
               if(var0 != null && var4 != null) {
                  if(!var0.startsWith("#") && !var4.startsWith("#")) {
                     var6 = var1.equals(var5);
                  } else {
                     var6 = var0.equals(var4);
                  }
               } else {
                  var6 = false;
               }

               if(var6) {
                  --client.field565;

                  for(int var7 = var2; var7 < client.field565; ++var7) {
                     client.field566[var7] = client.field566[var7 + 1];
                  }

                  client.field572 = client.field491;
                  client.field318.method2757(223);
                  client.field318.method2573(class45.method992(var0));
                  client.field318.method2661(var0);
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("p")
   public static class78 method184(class167 var0, int var1, int var2) {
      return !class121.method2747(var0, var1, var2)?null:class30.method673();
   }
}

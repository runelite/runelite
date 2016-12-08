import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public final class class33 extends Renderable {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -767557333
   )
   int field745;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1798421845
   )
   int field747;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 718999539
   )
   int field749;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1845644265
   )
   int field750;
   @ObfuscatedName("l")
   Sequence field751;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1735608583
   )
   int field752 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -463673121
   )
   int field753 = 0;
   @ObfuscatedName("k")
   boolean field754 = false;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 949568835
   )
   int field755;
   @ObfuscatedName("cd")
   static class208 field757;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 730211389
   )
   int field758;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "-12"
   )
   protected final Model getModel() {
      class190 var1 = NPCComposition.method3645(this.field749);
      Model var2;
      if(!this.field754) {
         var2 = var1.method3387(this.field752);
      } else {
         var2 = var1.method3387(-1);
      }

      return null == var2?null:var2;
   }

   class33(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field749 = var1;
      this.field747 = var2;
      this.field750 = var3;
      this.field745 = var4;
      this.field755 = var5;
      this.field758 = var7 + var6;
      int var8 = NPCComposition.method3645(this.field749).field2803;
      if(var8 != -1) {
         this.field754 = false;
         this.field751 = class31.getAnimation(var8);
      } else {
         this.field754 = true;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-40"
   )
   final void method672(int var1) {
      if(!this.field754) {
         this.field753 += var1;

         while(this.field753 > this.field751.frameLenghts[this.field752]) {
            this.field753 -= this.field751.frameLenghts[this.field752];
            ++this.field752;
            if(this.field752 >= this.field751.frameIDs.length) {
               this.field754 = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "-173770263"
   )
   static File method675(String var0) {
      if(!class107.field1737) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class107.field1732.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class107.field1731, var0);
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
                  class107.field1732.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)LFileOnDisk;",
      garbageValue = "-1006169785"
   )
   public static FileOnDisk method676(String var0, String var1, boolean var2) {
      File var3 = new File(class104.field1685, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class9.field70 == 33) {
         var4 = "_rc";
      } else if(class9.field70 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(WallObject.field1541, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "2053880911"
   )
   public static void method677(Buffer var0, int var1) {
      if(null != class104.field1687) {
         try {
            class104.field1687.method1353(0L);
            class104.field1687.method1358(var0.payload, var1, 24);
         } catch (Exception var3) {
            ;
         }
      }

   }
}

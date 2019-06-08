import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("im")
@Implements("KitDefinition")
public class KitDefinition extends DualNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("KitDefinition_indexCache")
   public static AbstractIndexCache KitDefinition_indexCache;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("__im_f")
   public static AbstractIndexCache __im_f;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 235389995
   )
   @Export("__im_q")
   public static int __im_q;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("KitDefinition_cached")
   static EvictingDualNodeHashTable KitDefinition_cached;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1619779051
   )
   @Export("__o")
   public int __o;
   @ObfuscatedName("u")
   @Export("__u")
   int[] __u;
   @ObfuscatedName("g")
   @Export("recolorFrom")
   short[] recolorFrom;
   @ObfuscatedName("l")
   @Export("recolorTo")
   short[] recolorTo;
   @ObfuscatedName("e")
   @Export("retextureFrom")
   short[] retextureFrom;
   @ObfuscatedName("x")
   @Export("retextureTo")
   short[] retextureTo;
   @ObfuscatedName("d")
   @Export("archives")
   int[] archives;
   @ObfuscatedName("k")
   @Export("__k")
   public boolean __k;

   static {
      KitDefinition_cached = new EvictingDualNodeHashTable(64);
   }

   KitDefinition() {
      this.__o = -1;
      this.archives = new int[]{-1, -1, -1, -1, -1};
      this.__k = false;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lgr;S)V",
      garbageValue = "22753"
   )
   @Export("read")
   void read(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgr;II)V",
      garbageValue = "-1828581673"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.__o = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.readUnsignedByte();
            this.__u = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.__u[var4] = var1.__ag_302();
            }
         } else if(var2 == 3) {
            this.__k = true;
         } else if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.recolorFrom = new short[var3];
            this.recolorTo = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.recolorFrom[var4] = (short)var1.__ag_302();
               this.recolorTo[var4] = (short)var1.__ag_302();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.retextureFrom = new short[var3];
            this.retextureTo = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.retextureFrom[var4] = (short)var1.__ag_302();
               this.retextureTo[var4] = (short)var1.__ag_302();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.archives[var2 - 60] = var1.__ag_302();
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1250940659"
   )
   @Export("__w_413")
   public boolean __w_413() {
      if(this.__u == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.__u.length; ++var2) {
            if(!__im_f.tryLoadRecord(this.__u[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Ldw;",
      garbageValue = "0"
   )
   @Export("__o_414")
   public ModelData __o_414() {
      if(this.__u == null) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.__u.length];

         for(int var2 = 0; var2 < this.__u.length; ++var2) {
            var1[var2] = ModelData.method2788(__im_f, this.__u[var2], 0);
         }

         ModelData var4;
         if(var1.length == 1) {
            var4 = var1[0];
         } else {
            var4 = new ModelData(var1, var1.length);
         }

         int var3;
         if(this.recolorFrom != null) {
            for(var3 = 0; var3 < this.recolorFrom.length; ++var3) {
               var4.recolor(this.recolorFrom[var3], this.recolorTo[var3]);
            }
         }

         if(this.retextureFrom != null) {
            for(var3 = 0; var3 < this.retextureFrom.length; ++var3) {
               var4.retexture(this.retextureFrom[var3], this.retextureTo[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "742548471"
   )
   @Export("__u_415")
   public boolean __u_415() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.archives[var2] != -1 && !__im_f.tryLoadRecord(this.archives[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)Ldw;",
      garbageValue = "-56"
   )
   @Export("__g_416")
   public ModelData __g_416() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.archives[var3] != -1) {
            var1[var2++] = ModelData.method2788(__im_f, this.archives[var3], 0);
         }
      }

      ModelData var5 = new ModelData(var1, var2);
      int var4;
      if(this.recolorFrom != null) {
         for(var4 = 0; var4 < this.recolorFrom.length; ++var4) {
            var5.recolor(this.recolorFrom[var4], this.recolorTo[var4]);
         }
      }

      if(this.retextureFrom != null) {
         for(var4 = 0; var4 < this.retextureFrom.length; ++var4) {
            var5.retexture(this.retextureFrom[var4], this.retextureTo[var4]);
         }
      }

      return var5;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lgr;I)Ljava/lang/String;",
      garbageValue = "-1225602201"
   )
   public static String method4866(Buffer var0) {
      String var1;
      try {
         int var2 = var0.__ae_307();
         if(var2 > 32767) {
            var2 = 32767;
         }

         byte[] var3 = new byte[var2];
         var0.index += class303.huffman.__f_294(var0.array, var0.index, var3, 0, var2);
         String var4 = WidgetGroupParent.decodeStringCp1252(var3, 0, var2);
         var1 = var4;
      } catch (Exception var6) {
         var1 = "Cabbage";
      }

      return var1;
   }
}

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ky")
public abstract class class297 implements Comparator {
   @ObfuscatedName("q")
   Comparator field3827;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;I)V",
      garbageValue = "-538844219"
   )
   final void method5272(Comparator var1) {
      if(this.field3827 == null) {
         this.field3827 = var1;
      } else if(this.field3827 instanceof class297) {
         ((class297)this.field3827).method5272(var1);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lkv;Lkv;B)I",
      garbageValue = "-63"
   )
   protected final int method5273(Nameable var1, Nameable var2) {
      return this.field3827 == null?0:this.field3827.compare(var1, var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lhq;III)I",
      garbageValue = "1972383959"
   )
   static int method5284(IterableHashTable var0, int var1, int var2) {
      if(var0 == null) {
         return var2;
      } else {
         IntegerNode var3 = (IntegerNode)var0.get((long)var1);
         return var3 == null?var2:var3.value;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)Lde;",
      garbageValue = "1768713002"
   )
   @Export("getPreferencesFile")
   public static FileOnDisk getPreferencesFile(String var0, String var1, boolean var2) {
      File var3 = new File(UrlRequest.field2092, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(WorldMapType2.field507 == 33) {
         var4 = "_rc";
      } else if(WorldMapType2.field507 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class167.userHome, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
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
}

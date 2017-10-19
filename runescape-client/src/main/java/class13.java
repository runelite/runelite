import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
public class class13 {
   @ObfuscatedName("s")
   public static Comparator field285;
   @ObfuscatedName("q")
   public static Comparator field286;
   @ObfuscatedName("o")
   public static Comparator field289;
   @ObfuscatedName("g")
   public static Comparator field288;
   @ObfuscatedName("w")
   public final List field290;

   static {
      field285 = new class19();
      new class12();
      field286 = new class17();
      field289 = new class18();
      field288 = new class15();
   }

   @ObfuscatedSignature(
      signature = "(Lfz;Z)V",
      garbageValue = "1"
   )
   public class13(Buffer var1, boolean var2) {
      int var3 = var1.readUnsignedShort();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUnsignedShort();
      this.field290 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field290.add(new class14(var1, var5, var3));
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "-660126978"
   )
   public void method75(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field290, var1);
      } else {
         Collections.sort(this.field290, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "(IZZZI)Lih;",
      garbageValue = "176379728"
   )
   @Export("openCacheIndex")
   static IndexData openCacheIndex(int var0, boolean var1, boolean var2, boolean var3) {
      IndexFile var4 = null;
      if(class155.field2239 != null) {
         var4 = new IndexFile(var0, class155.field2239, PacketBuffer.field2417[var0], 1000000);
      }

      return new IndexData(var4, class37.field534, var0, var1, var2, var3);
   }
}

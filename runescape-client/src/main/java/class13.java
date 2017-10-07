import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public class class13 {
   @ObfuscatedName("k")
   public static Comparator field281;
   @ObfuscatedName("e")
   public static Comparator field280;
   @ObfuscatedName("p")
   public static Comparator field283;
   @ObfuscatedName("q")
   public static Comparator field282;
   @ObfuscatedName("d")
   public final List field284;

   static {
      field281 = new class19();
      new class12();
      field280 = new class17();
      field283 = new class18();
      field282 = new class15();
   }

   @ObfuscatedSignature(
      signature = "(Lfg;Z)V",
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
      this.field284 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field284.add(new class14(var1, var5, var3));
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "1996887458"
   )
   public void method74(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field284, var1);
      } else {
         Collections.sort(this.field284, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Ldd;B)V",
      garbageValue = "5"
   )
   static final void method78(class117 var0) {
      var0.field1703 = false;
      if(var0.field1705 != null) {
         var0.field1705.field1737 = 0;
      }

      for(class117 var1 = var0.vmethod4025(); var1 != null; var1 = var0.vmethod4002()) {
         method78(var1);
      }

   }
}

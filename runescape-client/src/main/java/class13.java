import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
public class class13 {
   @ObfuscatedName("eo")
   @ObfuscatedSignature(
      signature = "Lfb;"
   )
   @Export("rssocket")
   static RSSocket rssocket;
   @ObfuscatedName("o")
   public static Comparator field264;
   @ObfuscatedName("i")
   public static Comparator field265;
   @ObfuscatedName("u")
   public static Comparator field263;
   @ObfuscatedName("g")
   public static Comparator field267;
   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   @Export("indexScripts")
   static IndexData indexScripts;
   @ObfuscatedName("c")
   public final List field266;

   static {
      field264 = new class19();
      new class12();
      field265 = new class17();
      field263 = new class18();
      field267 = new class15();
   }

   @ObfuscatedSignature(
      signature = "(Lfp;Z)V",
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
      this.field266 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field266.add(new class14(var1, var5, var3));
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "387237637"
   )
   public void method70(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field266, var1);
      } else {
         Collections.sort(this.field266, Collections.reverseOrder(var1));
      }

   }
}

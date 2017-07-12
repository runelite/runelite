import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
public class class13 {
   @ObfuscatedName("w")
   public static Comparator field277;
   @ObfuscatedName("a")
   public static Comparator field278;
   @ObfuscatedName("t")
   public static Comparator field279;
   @ObfuscatedName("s")
   public static Comparator field280;
   @ObfuscatedName("km")
   static class89 field281;
   @ObfuscatedName("i")
   public final List field283;

   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1245000480"
   )
   static final void method60() {
      if(Client.field978 > 0) {
         class64.method1116();
      } else {
         TextureProvider.setGameState(40);
         class215.field2640 = class244.rssocket;
         class244.rssocket = null;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "-1884021892"
   )
   public void method61(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field283, var1);
      } else {
         Collections.sort(this.field283, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
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
      this.field283 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field283.add(new class14(var1, var5, var3));
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "8"
   )
   static void method64(String var0, String var1, String var2) {
      class92.loginMessage1 = var0;
      class92.loginMessage2 = var1;
      class92.loginMessage3 = var2;
   }

   static {
      field277 = new class19();
      new class12();
      field278 = new class17();
      field279 = new class18();
      field280 = new class15();
   }
}

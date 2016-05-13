import java.io.File;
import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("d")
public class class4 {
   @ObfuscatedName("j")
   static final BigInteger field71 = new BigInteger("9d6d215cde69efde241cf9cb97d74972d3abebc62c80e55c72d1e0ba8d8cecbadfe65c2cd2fa1207f450e5d9126c8c613dd2e5d960c7eeba305b67dd15e512776b7954087fa0f8b196fe41bf3016d1c766c7f5e4e933440540b917d315dd9bb1debf23dbe78cf47ca7d712c5a74625fdd651178fb13dde9ec72f41be77dd68bd", 16);
   @ObfuscatedName("d")
   public static File field72;
   @ObfuscatedName("s")
   static final BigInteger field74 = new BigInteger("10001", 16);
   @ObfuscatedName("bn")
   static class168 field75;
   @ObfuscatedName("iq")
   static class173 field78;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZS)[B",
      garbageValue = "0"
   )
   public static byte[] method39(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var3 = (byte[])((byte[])((byte[])var0));
         return var3;
      } else if(var0 instanceof class125) {
         class125 var2 = (class125)var0;
         return var2.vmethod2795();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "7"
   )
   static void method40() {
      int var0 = class15.field214;
      int var1 = class15.field215;
      if(class32.field770 < var0) {
         var0 = class32.field770;
      }

      if(class131.field2079 < var1) {
         var1 = class131.field2079;
      }

      if(class76.field1388 != null) {
         try {
            client var2 = client.field276;
            int var3 = client.field336?2:1;
            Object[] var4 = new Object[]{Integer.valueOf(var3)};
            JSObject.getWindow(var2).call("resize", var4);
         } catch (Throwable var5) {
            ;
         }
      }

   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "82"
   )
   static final void method41(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < client.field480; ++var4) {
         if(client.field485[var4] + client.field477[var4] > var0 && client.field485[var4] < var0 + var2 && client.field488[var4] + client.field486[var4] > var1 && client.field486[var4] < var1 + var3) {
            client.field482[var4] = true;
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Lclass42;",
      garbageValue = "398113809"
   )
   @Export("getAnimation")
   public static class42 method42(int var0) {
      class42 var1 = (class42)class42.field984.method3743((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class42.field985.method3239(12, var0);
         var1 = new class42();
         if(var2 != null) {
            var1.method838(new class119(var2));
         }

         var1.method868();
         class42.field984.method3745(var1, (long)var0);
         return var1;
      }
   }
}

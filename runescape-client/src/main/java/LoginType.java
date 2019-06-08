import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lx")
@Implements("LoginType")
public class LoginType {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Llx;"
   )
   @Export("__lx_m")
   public static final LoginType __lx_m;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Llx;"
   )
   @Export("__lx_f")
   static final LoginType __lx_f;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Llx;"
   )
   @Export("__lx_q")
   static final LoginType __lx_q;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Llx;"
   )
   @Export("__lx_w")
   static final LoginType __lx_w;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Llx;"
   )
   @Export("__lx_o")
   static final LoginType __lx_o;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Llx;"
   )
   @Export("__lx_u")
   static final LoginType __lx_u;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Llx;"
   )
   @Export("__lx_g")
   static final LoginType __lx_g;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Llx;"
   )
   @Export("__lx_l")
   static final LoginType __lx_l;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Llx;"
   )
   @Export("__lx_e")
   public static final LoginType __lx_e;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1916729379
   )
   @Export("__x")
   public final int __x;
   @ObfuscatedName("d")
   @Export("__d")
   final String __d;

   static {
      __lx_m = new LoginType(8, 0, "", "");
      __lx_f = new LoginType(3, 1, "", "");
      __lx_q = new LoginType(2, 2, "", "");
      __lx_w = new LoginType(6, 3, "", "");
      __lx_o = new LoginType(4, 4, "", "");
      __lx_u = new LoginType(7, 5, "", "");
      __lx_g = new LoginType(1, 6, "", "");
      __lx_l = new LoginType(5, 7, "", "");
      __lx_e = new LoginType(0, -1, "", "", true, new LoginType[]{__lx_m, __lx_f, __lx_q, __lx_o, __lx_w});
   }

   LoginType(int var1, int var2, String var3, String var4) {
      this.__x = var1;
      this.__d = var4;
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;Z[Llx;)V"
   )
   LoginType(int var1, int var2, String var3, String var4, boolean var5, LoginType[] var6) {
      this.__x = var1;
      this.__d = var4;
   }

   @Export("__toString_546")
   @ObfuscatedName("toString")
   public String __toString_546() {
      return this.__d;
   }
}

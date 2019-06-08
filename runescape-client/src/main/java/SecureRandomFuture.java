import java.security.SecureRandom;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
@Implements("SecureRandomFuture")
public class SecureRandomFuture {
   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "Llq;"
   )
   @Export("__cn_bu")
   static IndexedSprite __cn_bu;
   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("indexCache5")
   static IndexCache indexCache5;
   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      signature = "Ldl;"
   )
   @Export("textureProvider")
   static TextureProvider textureProvider;
   @ObfuscatedName("m")
   @Export("executor")
   ExecutorService executor;
   @ObfuscatedName("f")
   @Export("future")
   Future future;

   SecureRandomFuture() {
      this.executor = Executors.newSingleThreadExecutor();
      this.future = this.executor.submit(new SecureRandomCallable());
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "201982911"
   )
   @Export("shutdown")
   void shutdown() {
      this.executor.shutdown();
      this.executor = null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1746832096"
   )
   @Export("isDone")
   boolean isDone() {
      return this.future.isDone();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Ljava/security/SecureRandom;",
      garbageValue = "1216808827"
   )
   @Export("get")
   SecureRandom get() {
      try {
         return (SecureRandom)this.future.get();
      } catch (Exception var2) {
         return AttackOption.method2034();
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1209786285"
   )
   static void method2104() {
      Iterator var0 = Messages.Messages_hashTable.iterator();

      while(var0.hasNext()) {
         Message var1 = (Message)var0.next();
         var1.clearIsFromIgnored();
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1357745818"
   )
   public static boolean method2101(int var0) {
      return (var0 >> 31 & 1) != 0;
   }
}
